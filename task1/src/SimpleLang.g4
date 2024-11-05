grammar SimpleLang;

prog : dec+ EOF;

dec
    : typed_idfr LParen (vardec+=typed_idfr (Comma vardec+=typed_idfr)*)? RParen body
;

typed_idfr
    : type Idfr
;

type
    : IntType | BoolType | UnitType
;

body
    : LBrace ene+=exp (Semicolon ene+=exp)* RBrace
;

block
    : LBrace ene+=exp (Semicolon ene+=exp)* RBrace
;

exp
    : Idfr Assign exp                                       #AssignExpr
    | typed_idfr Assign exp                                 #DecAssignExpr
    | LParen exp binop exp RParen                           #BinOpExpr
    | LParen unop exp RParen                                #UnaryOpExpr
    | Idfr LParen (args+=exp (Comma args+=exp)*)? RParen    #InvokeExpr
    | block                                                 #BlockExpr
    | If exp Then block Else block                          #IfExpr
    | While exp Do block                                    #WhileExpr
    | Repeat block Until exp                                #RepeatUntilExpr
    | Print exp                                             #PrintExpr
    | Print NewLine                                         #PrintNewLineExpr
    | Space                                                 #SpaceExpr
    | Idfr                                                  #IdExpr
    | IntLit                                                #IntExpr
    | BoolLit                                               #BoolExpr
;

binop
    : Eq              #EqBinop
    | Less            #LessBinop
    | LessEq          #LessEqBinop
    | More            #MoreBinop
    | MoreEq          #MoreEqBinop
    | Plus            #PlusBinop
    | Minus           #MinusBinop
    | Times           #TimesBinop
    | Divide          #DivideBinop
    | And             #AndBinop
    | Or              #OrBinop
;

unop
    : Not             # NotUnop
;

LParen : '(' ;
Comma : ',' ;
RParen : ')' ;
LBrace : '{' ;
Semicolon : ';' ;
RBrace : '}' ;

Eq : '==' ;
Less : '<' ;
LessEq : '<=' ;
More : '>' ;
MoreEq : '>=' ;
And : '&' ;
Or : '|' ;
Not : '!' ;

Plus : '+' ;
Times : '*' ;
Minus : '-' ;
Divide : '/' ;

Assign : ':=' ;

Print : 'print' ;
Space : 'space' ;
NewLine : 'newline' ;
If : 'if' ;
Then : 'then' ;
Else : 'else' ;
While : 'while' ;
Do : 'do' ;
Repeat : 'repeat' ;
Until: 'until' ;

IntType : 'int' ;
BoolType : 'bool' ;
UnitType : 'unit' ;

BoolLit : 'true' | 'false' ;
IntLit : '0' | ('-'? [1-9][0-9]*) ;
Idfr : [a-z][A-Za-z0-9_]* ;
WS : [ \n\r\t]+ -> skip ;