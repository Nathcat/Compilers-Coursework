import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class SimpleLangInterpreter extends AbstractParseTreeVisitor<Integer> implements SimpleLangVisitor<Integer> {

    private static class TypedIdfr {
        public final String name;
        private final SimpleLangParser.Typed_idfrContext ctx;
        private Integer value;

        public TypedIdfr(String name, SimpleLangParser.Typed_idfrContext ctx) {
            this.name = name;
            this.ctx = ctx;
        }

        public Integer set(Integer value) {
            if (ctx.type().BoolType() != null) {
                if (value < 0 || value > 1) {
                    throw new RuntimeException("Value " + value + " may not be cast to a boolean.");
                }
                else {
                    this.value = value;
                }
            }
            else {
                this.value = value;
            }

            return this.value;
        }

        public Integer get() {
            return this.value;
        }
    }

    private final Map<String, SimpleLangParser.DecContext> global_funcs = new HashMap<>();
    private final Stack<Map<String, TypedIdfr>> frames = new Stack<>();

    public Integer visitTreeEnforceType(ParseTree exp, int type) {
        Integer r = visit(exp);

        if (type == SimpleLangParser.BoolType) {
            if (r == null || r < 0 || r > 1) {
                throw new RuntimeException("Expression '" + exp.getText() + "' must return bool-like type.");
            }
            else {
                return r;
            }
        }
        else if (type == SimpleLangParser.IntType) {
            if (r != null) return r;
            else throw new RuntimeException("Expression '" + exp.getText() + "' must return integer type.");
        }

        return r;
    }

    public int determineType(SimpleLangParser.TypeContext ctx) {
        if (ctx.IntType() != null) return SimpleLangParser.IntType;
        else if (ctx.BoolType() != null) return SimpleLangParser.BoolType;
        else return SimpleLangParser.UnitType;
    }

    public Integer visitProgram(SimpleLangParser.ProgContext ctx, String[] args)
    {
        for (int i = 0; i < ctx.dec().size(); ++i) {

            SimpleLangParser.DecContext dec = ctx.dec(i);
            SimpleLangParser.Typed_idfrContext typedIdfr = dec.typed_idfr(0);

            if (global_funcs.containsKey(typedIdfr.Idfr().getText())) {
                throw new RuntimeException("Function " + typedIdfr.Idfr().getText() + " already exists!");
            }

            global_funcs.put(typedIdfr.Idfr().getText(), dec);

        }

        SimpleLangParser.DecContext main = global_funcs.get("main");

        Map<String, TypedIdfr> newFrame = new HashMap<>();
        for (int i = 0; i < args.length; ++i) {
            if (args[i].equals("true")) {
                TypedIdfr t = new TypedIdfr(main.vardec.get(i).Idfr().getText(), main.vardec.get(i));
                t.set(1);
                newFrame.put(main.vardec.get(i).Idfr().getText(), t);
            } else if (args[i].equals("false")) {
                TypedIdfr t = new TypedIdfr(main.vardec.get(i).Idfr().getText(), main.vardec.get(i));
                t.set(0);
                newFrame.put(main.vardec.get(i).Idfr().getText(), t);
            } else {
                TypedIdfr t = new TypedIdfr(main.vardec.get(i).Idfr().getText(), main.vardec.get(i));
                t.set(Integer.parseInt(args[i]));
                newFrame.put(main.vardec.get(i).Idfr().getText(), t);
            }
        }

        frames.push(newFrame);
        return visit(main);

    }

    @Override public Integer visitProg(SimpleLangParser.ProgContext ctx)
    {

        throw new RuntimeException("Should not be here!");

    }

    @Override public Integer visitDec(SimpleLangParser.DecContext ctx)
    {

        Integer returnValue = visitTreeEnforceType(ctx.body(), determineType(ctx.typed_idfr(0).type()));
        frames.pop();
        return returnValue;

    }

    @Override public Integer visitTyped_idfr(SimpleLangParser.Typed_idfrContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Integer visitType(SimpleLangParser.TypeContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Integer visitBody(SimpleLangParser.BodyContext ctx) {

        Integer returnValue = null;
        for (int i = 0; i < ctx.ene.size(); ++i) {
            SimpleLangParser.ExpContext exp = ctx.ene.get(i);
            returnValue = visit(exp);
        }
        return returnValue;

    }

    @Override public Integer visitBlock(SimpleLangParser.BlockContext ctx)
    {
        Integer returnValue = null;
        for (int i = 0; i < ctx.ene.size(); ++i) {
            SimpleLangParser.ExpContext exp = ctx.ene.get(i);
            returnValue = visit(exp);
        }
        return returnValue;
    }

    @Override public Integer visitAssignExpr(SimpleLangParser.AssignExprContext ctx)
    {

        if (!frames.peek().containsKey(ctx.Idfr().getText())) {
            throw new RuntimeException("Variable " + ctx.Idfr().getText() + " does not exist.");
        }

        frames.peek().get(ctx.Idfr().getText()).set(visit(ctx.exp()));
        return null;

    }

    @Override
    public Integer visitDecAssignExpr(SimpleLangParser.DecAssignExprContext ctx) {
        TypedIdfr t = new TypedIdfr(ctx.typed_idfr().Idfr().getText(), ctx.typed_idfr());
        t.set(
                visitTreeEnforceType(ctx.exp(), determineType(ctx.typed_idfr().type()))
        );
        frames.peek().put(ctx.typed_idfr().Idfr().getText(), t);
        return null;

    }

    @Override public Integer visitBinOpExpr(SimpleLangParser.BinOpExprContext ctx) {

        SimpleLangParser.ExpContext operand1 = ctx.exp(0);
        Integer oprnd1 = visit(operand1);
        SimpleLangParser.ExpContext operand2 = ctx.exp(1);
        Integer oprnd2 = visit(operand2);

        switch (((TerminalNode) (ctx.binop().getChild(0))).getSymbol().getType()) {

            case SimpleLangParser.Eq ->  {

                return ((Objects.equals(oprnd1, oprnd2)) ? 1 : 0);

            }
            case SimpleLangParser.Less -> {

                return ((oprnd1 < oprnd2) ? 1 : 0);

            }
            case SimpleLangParser.LessEq -> {

                return ((oprnd1 <= oprnd2) ? 1 : 0);

            }
            case SimpleLangParser.More -> {

                return ((oprnd1 > oprnd2) ? 1 : 0);

            }
            case SimpleLangParser.MoreEq -> {

                return (oprnd1 >= oprnd2) ? 1 : 0;

            }
            case SimpleLangParser.Plus -> {

                return oprnd1 + oprnd2;

            }
            case SimpleLangParser.Minus -> {

                return oprnd1 - oprnd2;

            }
            case SimpleLangParser.Times -> {

                return oprnd1 * oprnd2;

            }
            case SimpleLangParser.Divide -> {

                return oprnd1 / oprnd2;

            }
            case SimpleLangParser.And -> {

                boolean o1b = oprnd1 == 1;
                boolean o2b = oprnd2 == 1;
                return o1b && o2b ? 1 : 0;

            }
            case SimpleLangParser.Or -> {

                boolean o1b = oprnd1 == 1;
                boolean o2b = oprnd2 == 1;
                return o1b || o2b ? 1 : 0;

            }
            default -> {
                throw new RuntimeException("Shouldn't be here - wrong binary operator.");
            }

        }

    }

    @Override
    public Integer visitUnaryOpExpr(SimpleLangParser.UnaryOpExprContext ctx) {
         Integer operand = visit(ctx.exp());

         switch (((TerminalNode) (ctx.unop().getChild(0))).getSymbol().getType()) {
             case SimpleLangParser.Not -> {

                 return operand == 1 ? 0 : 1;

             }
             default -> {
                 throw new RuntimeException("Incorrect unary operator, this should not be here");
             }
         }
    }

    @Override public Integer visitInvokeExpr(SimpleLangParser.InvokeExprContext ctx)
    {

        SimpleLangParser.DecContext dec = global_funcs.get(ctx.Idfr().getText());
        Map<String, TypedIdfr> newFrame = new HashMap<>();

        for (int i = 0; i < dec.vardec.size(); i++) {
            SimpleLangParser.Typed_idfrContext param = dec.vardec.get(i);
            SimpleLangParser.ExpContext exp = ctx.args.get(i);
            TypedIdfr t = new TypedIdfr(param.Idfr().getText(), param);
            t.set(visit(exp));
            newFrame.put(t.name, t);
        }

        frames.push(newFrame);
        return visit(dec);

    }

    @Override public Integer visitBlockExpr(SimpleLangParser.BlockExprContext ctx) {
        return visit(ctx.block());
    }

    @Override public Integer visitIfExpr(SimpleLangParser.IfExprContext ctx)
    {

        SimpleLangParser.ExpContext cond = ctx.exp();
        Integer condValue = visitTreeEnforceType(cond, SimpleLangParser.BoolType);
        if (condValue > 0) {

            SimpleLangParser.BlockContext thenBlock = ctx.block(0);
            return visit(thenBlock);

        } else {

            SimpleLangParser.BlockContext elseBlock = ctx.block(1);
            return visit(elseBlock);

        }

    }

    @Override
    public Integer visitWhileExpr(SimpleLangParser.WhileExprContext ctx) {
        SimpleLangParser.ExpContext conditionExp = ctx.exp();

        // Expression must return bool-like type

        Integer result = null;

        while (visitTreeEnforceType(conditionExp, SimpleLangParser.BoolType) == 1) {
            result = visit(ctx.block());
        }

        // Allowed the while statement to return here.
        // This means that the following might be valid:
        //
        // int main() {
        //      while (some_condition) {
        //          ... do some stuff
        //          if (stuff worked) then {
        //              5
        //          } else {
        //              6
        //          }
        //      }
        // }
        //
        // The alternative might be
        //
        // int main() {
        //      int a := 6;
        //      while (some_condition) {
        //          ... do some stuff
        //          if (stuff worked) then {
        //              5
        //          } else { skip }
        //      }
        //      a
        // }
        //
        // Which would still be valid, but just felt unnecessary?
        return result;
    }

    @Override
    public Integer visitRepeatUntilExpr(SimpleLangParser.RepeatUntilExprContext ctx) {
        SimpleLangParser.ExpContext conditionExp = ctx.exp();

        do {
            visit(ctx.block());
        }
        while (!(visitTreeEnforceType(conditionExp, SimpleLangParser.BoolType) == 1));  // Not because in the language it is repeat "until" not "while".

        return null;
    }

    @Override public Integer visitPrintExpr(SimpleLangParser.PrintExprContext ctx) {

        SimpleLangParser.ExpContext exp = ctx.exp();

        if (((TerminalNode) exp.getChild(0)).getSymbol().getType() == SimpleLangParser.Space) {

            System.out.print(" ");

        } else if (((TerminalNode) exp.getChild(0)).getSymbol().getType() == SimpleLangParser.NewLine) {

            System.out.println();

        } else {

            System.out.print(visit(exp));

        }

        return null;

    }

    @Override
    public Integer visitNewLineExpr(SimpleLangParser.NewLineExprContext ctx) {
        return null;
    }

    @Override public Integer visitSpaceExpr(SimpleLangParser.SpaceExprContext ctx) {
        return null;
    }

    @Override
    public Integer visitSkipExpr(SimpleLangParser.SkipExprContext ctx) {
        return null;
    }

    @Override public Integer visitIdExpr(SimpleLangParser.IdExprContext ctx)
    {
        if (!frames.peek().containsKey(ctx.Idfr().getText())) throw new RuntimeException("Identifier " + ctx.Idfr().getText() + " not found!");
        return frames.peek().get(ctx.Idfr().getText()).get();
    }

    @Override public Integer visitIntExpr(SimpleLangParser.IntExprContext ctx)
    {

        return Integer.parseInt(ctx.IntLit().getText());

    }

    @Override
    public Integer visitBoolExpr(SimpleLangParser.BoolExprContext ctx) {
        return ctx.BoolLit().getText().contentEquals("true") ? 1 : 0;
    }

    @Override public Integer visitEqBinop(SimpleLangParser.EqBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitLessBinop(SimpleLangParser.LessBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitLessEqBinop(SimpleLangParser.LessEqBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    @Override
    public Integer visitMoreBinop(SimpleLangParser.MoreBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    @Override
    public Integer visitMoreEqBinop(SimpleLangParser.MoreEqBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Integer visitPlusBinop(SimpleLangParser.PlusBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitMinusBinop(SimpleLangParser.MinusBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitTimesBinop(SimpleLangParser.TimesBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    @Override
    public Integer visitDivideBinop(SimpleLangParser.DivideBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    @Override
    public Integer visitAndBinop(SimpleLangParser.AndBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    @Override
    public Integer visitOrBinop(SimpleLangParser.OrBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    @Override
    public Integer visitNotUnop(SimpleLangParser.NotUnopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
}