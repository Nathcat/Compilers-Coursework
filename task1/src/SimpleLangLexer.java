// Generated from C:/Users/super/Documents/GitHub/Compilers-Coursework/task1/src/SimpleLang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SimpleLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LParen=1, Comma=2, RParen=3, LBrace=4, Semicolon=5, RBrace=6, Eq=7, Less=8, 
		LessEq=9, Plus=10, Times=11, Minus=12, Assign=13, Print=14, Space=15, 
		NewLine=16, If=17, Then=18, Else=19, While=20, Do=21, IntType=22, BoolType=23, 
		UnitType=24, BoolLit=25, IntLit=26, Idfr=27, WS=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LParen", "Comma", "RParen", "LBrace", "Semicolon", "RBrace", "Eq", "Less", 
			"LessEq", "Plus", "Times", "Minus", "Assign", "Print", "Space", "NewLine", 
			"If", "Then", "Else", "While", "Do", "IntType", "BoolType", "UnitType", 
			"BoolLit", "IntLit", "Idfr", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "'{'", "';'", "'}'", "'=='", "'<'", "'<='", 
			"'+'", "'*'", "'-'", "':='", "'print'", "'space'", "'newline'", "'if'", 
			"'then'", "'else'", "'while'", "'do'", "'int'", "'bool'", "'unit'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LParen", "Comma", "RParen", "LBrace", "Semicolon", "RBrace", "Eq", 
			"Less", "LessEq", "Plus", "Times", "Minus", "Assign", "Print", "Space", 
			"NewLine", "If", "Then", "Else", "While", "Do", "IntType", "BoolType", 
			"UnitType", "BoolLit", "IntLit", "Idfr", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public SimpleLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001c\u00b4\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0003\u0018\u0098\b\u0018\u0001\u0019\u0001\u0019\u0003\u0019\u009c"+
		"\b\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u00a0\b\u0019\n\u0019\f\u0019"+
		"\u00a3\t\u0019\u0003\u0019\u00a5\b\u0019\u0001\u001a\u0001\u001a\u0005"+
		"\u001a\u00a9\b\u001a\n\u001a\f\u001a\u00ac\t\u001a\u0001\u001b\u0004\u001b"+
		"\u00af\b\u001b\u000b\u001b\f\u001b\u00b0\u0001\u001b\u0001\u001b\u0000"+
		"\u0000\u001c\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016"+
		"-\u0017/\u00181\u00193\u001a5\u001b7\u001c\u0001\u0000\u0005\u0001\u0000"+
		"19\u0001\u000009\u0001\u0000az\u0004\u000009AZ__az\u0003\u0000\t\n\r\r"+
		"  \u00b9\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001"+
		"\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000"+
		"\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000"+
		"\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003"+
		"\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000"+
		"\u0000\u0000\u00019\u0001\u0000\u0000\u0000\u0003;\u0001\u0000\u0000\u0000"+
		"\u0005=\u0001\u0000\u0000\u0000\u0007?\u0001\u0000\u0000\u0000\tA\u0001"+
		"\u0000\u0000\u0000\u000bC\u0001\u0000\u0000\u0000\rE\u0001\u0000\u0000"+
		"\u0000\u000fH\u0001\u0000\u0000\u0000\u0011J\u0001\u0000\u0000\u0000\u0013"+
		"M\u0001\u0000\u0000\u0000\u0015O\u0001\u0000\u0000\u0000\u0017Q\u0001"+
		"\u0000\u0000\u0000\u0019S\u0001\u0000\u0000\u0000\u001bV\u0001\u0000\u0000"+
		"\u0000\u001d\\\u0001\u0000\u0000\u0000\u001fb\u0001\u0000\u0000\u0000"+
		"!j\u0001\u0000\u0000\u0000#m\u0001\u0000\u0000\u0000%r\u0001\u0000\u0000"+
		"\u0000\'w\u0001\u0000\u0000\u0000)}\u0001\u0000\u0000\u0000+\u0080\u0001"+
		"\u0000\u0000\u0000-\u0084\u0001\u0000\u0000\u0000/\u0089\u0001\u0000\u0000"+
		"\u00001\u0097\u0001\u0000\u0000\u00003\u00a4\u0001\u0000\u0000\u00005"+
		"\u00a6\u0001\u0000\u0000\u00007\u00ae\u0001\u0000\u0000\u00009:\u0005"+
		"(\u0000\u0000:\u0002\u0001\u0000\u0000\u0000;<\u0005,\u0000\u0000<\u0004"+
		"\u0001\u0000\u0000\u0000=>\u0005)\u0000\u0000>\u0006\u0001\u0000\u0000"+
		"\u0000?@\u0005{\u0000\u0000@\b\u0001\u0000\u0000\u0000AB\u0005;\u0000"+
		"\u0000B\n\u0001\u0000\u0000\u0000CD\u0005}\u0000\u0000D\f\u0001\u0000"+
		"\u0000\u0000EF\u0005=\u0000\u0000FG\u0005=\u0000\u0000G\u000e\u0001\u0000"+
		"\u0000\u0000HI\u0005<\u0000\u0000I\u0010\u0001\u0000\u0000\u0000JK\u0005"+
		"<\u0000\u0000KL\u0005=\u0000\u0000L\u0012\u0001\u0000\u0000\u0000MN\u0005"+
		"+\u0000\u0000N\u0014\u0001\u0000\u0000\u0000OP\u0005*\u0000\u0000P\u0016"+
		"\u0001\u0000\u0000\u0000QR\u0005-\u0000\u0000R\u0018\u0001\u0000\u0000"+
		"\u0000ST\u0005:\u0000\u0000TU\u0005=\u0000\u0000U\u001a\u0001\u0000\u0000"+
		"\u0000VW\u0005p\u0000\u0000WX\u0005r\u0000\u0000XY\u0005i\u0000\u0000"+
		"YZ\u0005n\u0000\u0000Z[\u0005t\u0000\u0000[\u001c\u0001\u0000\u0000\u0000"+
		"\\]\u0005s\u0000\u0000]^\u0005p\u0000\u0000^_\u0005a\u0000\u0000_`\u0005"+
		"c\u0000\u0000`a\u0005e\u0000\u0000a\u001e\u0001\u0000\u0000\u0000bc\u0005"+
		"n\u0000\u0000cd\u0005e\u0000\u0000de\u0005w\u0000\u0000ef\u0005l\u0000"+
		"\u0000fg\u0005i\u0000\u0000gh\u0005n\u0000\u0000hi\u0005e\u0000\u0000"+
		"i \u0001\u0000\u0000\u0000jk\u0005i\u0000\u0000kl\u0005f\u0000\u0000l"+
		"\"\u0001\u0000\u0000\u0000mn\u0005t\u0000\u0000no\u0005h\u0000\u0000o"+
		"p\u0005e\u0000\u0000pq\u0005n\u0000\u0000q$\u0001\u0000\u0000\u0000rs"+
		"\u0005e\u0000\u0000st\u0005l\u0000\u0000tu\u0005s\u0000\u0000uv\u0005"+
		"e\u0000\u0000v&\u0001\u0000\u0000\u0000wx\u0005w\u0000\u0000xy\u0005h"+
		"\u0000\u0000yz\u0005i\u0000\u0000z{\u0005l\u0000\u0000{|\u0005e\u0000"+
		"\u0000|(\u0001\u0000\u0000\u0000}~\u0005d\u0000\u0000~\u007f\u0005o\u0000"+
		"\u0000\u007f*\u0001\u0000\u0000\u0000\u0080\u0081\u0005i\u0000\u0000\u0081"+
		"\u0082\u0005n\u0000\u0000\u0082\u0083\u0005t\u0000\u0000\u0083,\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0005b\u0000\u0000\u0085\u0086\u0005o\u0000"+
		"\u0000\u0086\u0087\u0005o\u0000\u0000\u0087\u0088\u0005l\u0000\u0000\u0088"+
		".\u0001\u0000\u0000\u0000\u0089\u008a\u0005u\u0000\u0000\u008a\u008b\u0005"+
		"n\u0000\u0000\u008b\u008c\u0005i\u0000\u0000\u008c\u008d\u0005t\u0000"+
		"\u0000\u008d0\u0001\u0000\u0000\u0000\u008e\u008f\u0005t\u0000\u0000\u008f"+
		"\u0090\u0005r\u0000\u0000\u0090\u0091\u0005u\u0000\u0000\u0091\u0098\u0005"+
		"e\u0000\u0000\u0092\u0093\u0005f\u0000\u0000\u0093\u0094\u0005a\u0000"+
		"\u0000\u0094\u0095\u0005l\u0000\u0000\u0095\u0096\u0005s\u0000\u0000\u0096"+
		"\u0098\u0005e\u0000\u0000\u0097\u008e\u0001\u0000\u0000\u0000\u0097\u0092"+
		"\u0001\u0000\u0000\u0000\u00982\u0001\u0000\u0000\u0000\u0099\u00a5\u0005"+
		"0\u0000\u0000\u009a\u009c\u0005-\u0000\u0000\u009b\u009a\u0001\u0000\u0000"+
		"\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000"+
		"\u0000\u009d\u00a1\u0007\u0000\u0000\u0000\u009e\u00a0\u0007\u0001\u0000"+
		"\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a4\u0099\u0001\u0000\u0000\u0000\u00a4\u009b\u0001\u0000\u0000"+
		"\u0000\u00a54\u0001\u0000\u0000\u0000\u00a6\u00aa\u0007\u0002\u0000\u0000"+
		"\u00a7\u00a9\u0007\u0003\u0000\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a9\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab6\u0001\u0000\u0000\u0000\u00ac"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ad\u00af\u0007\u0004\u0000\u0000\u00ae"+
		"\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0"+
		"\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0006\u001b\u0000\u0000\u00b3"+
		"8\u0001\u0000\u0000\u0000\u0007\u0000\u0097\u009b\u00a1\u00a4\u00aa\u00b0"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}