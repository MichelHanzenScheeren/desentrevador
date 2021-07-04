/* Generated By:JavaCC: Do not edit this line. Lexer.java */
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Lexer implements LexerConstants {
        public static void execute(Lexer analisador) throws ParseException {
                analisador.main();
                System.out.println("\u005cn --------------------");
            System.out.println(" Mas ah indio veio!");
            System.out.println(" --------------------");
        }

        public static void main(String[] args) {
        try {
            if(args.length == 0) {
                    System.out.println("\u005cnInforme seu codigo: ");
                    execute(new Lexer(System.in));
                } else if(args[0].contains("-f")) {
                    System.out.println("\u005cnSelecione o arquivo do programa: ");
                        JFileChooser arquivo = new JFileChooser();
                        arquivo.showOpenDialog(null);
                        File selected = arquivo.getSelectedFile();
                        if(selected != null) {
                                FileInputStream stream = new FileInputStream(selected.getAbsolutePath());
                                execute(new Lexer(stream));
                        } else {
                          System.out.println("\u005cn\u005cn------------------------------------");
                          System.out.println("Processo cancelado pelo usuario!");
                          System.out.println("--------------------------------");
                          return;
                        }
                } else {
                        FileInputStream stream = new FileInputStream(args[0]);
                        execute(new Lexer(stream));
                }
        } catch (Throwable e) {
            System.out.println("Programa invalido!\u005cn " + e.getMessage());
        }
    }

  static final public void main() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FIM_LINHA:
      case LOQUEANDO:
      case REPETECO:
      case SE:
      case REDONDO:
      case QUEBRADO:
      case TROVA:
      case LOGICO:
      case NOME_VARIAVEL:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FIM_LINHA:
      case REDONDO:
      case QUEBRADO:
      case TROVA:
      case LOGICO:
      case NOME_VARIAVEL:
        linha();
        break;
      case LOQUEANDO:
      case REPETECO:
      case SE:
        bloco();
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    fimDePrograma();
  }

/* METODOS RELACIONADOS AOS TOKENS PARA POSTERIOR CONSTRUCAO DA ARVORE DE DERIVACAO */
  static final public void nomeVariavel() throws ParseException {
    jj_consume_token(NOME_VARIAVEL);
  }

  static final public void numeroComSinal() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MAIS:
    case MENOS:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MAIS:
        jj_consume_token(MAIS);
        break;
      case MENOS:
        jj_consume_token(MENOS);
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    jj_consume_token(NUMERO);
  }

  static final public void simboloAtribuicao() throws ParseException {
    jj_consume_token(ATRIBUICAO);
  }

  static final public void fimLinha() throws ParseException {
    jj_consume_token(FIM_LINHA);
  }

  static final public void virgula() throws ParseException {
    jj_consume_token(VIRGULA);
  }

  static final public void loqueando() throws ParseException {
    jj_consume_token(LOQUEANDO);
  }

  static final public void repeteco() throws ParseException {
    jj_consume_token(REPETECO);
  }

  static final public void inicioBloco() throws ParseException {
    jj_consume_token(INICIO_BLOCO);
  }

  static final public void fimBloco() throws ParseException {
    jj_consume_token(FIM_BLOCO);
    jj_consume_token(FIM_LINHA);
  }

  static final public void inicioOperacaoLinha() throws ParseException {
    jj_consume_token(OPERACAO_DE_LINHA);
  }

  static final public void minRepeteco() throws ParseException {
    jj_consume_token(MIN_REPETECO);
  }

  static final public void maxRepeteco() throws ParseException {
    jj_consume_token(MAX_REPETECO);
  }

  static final public void se() throws ParseException {
    jj_consume_token(SE);
  }

  static final public void senao() throws ParseException {
    jj_consume_token(SENAO);
  }

/* INICIO DA LOGICA DE VALIDACAO DA LINGUAGEM */
  static final public void linha() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case REDONDO:
    case QUEBRADO:
    case TROVA:
    case LOGICO:
    case NOME_VARIAVEL:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NOME_VARIAVEL:
        atribuicao();
        break;
      case REDONDO:
      case QUEBRADO:
      case TROVA:
      case LOGICO:
        declaracaoDeVariavel();
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      fimLinha();
      break;
    case FIM_LINHA:
      fimLinha();
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void atribuicao() throws ParseException {
    nomeVariavel();
    lacoDeAtribuicao();
  }

  static final public void lacoDeAtribuicao() throws ParseException {
    simboloAtribuicao();
    expressaoMatematica();
  }

  static final public void expressaoMatematica() throws ParseException {
    expressaoLogica();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MAIS:
      case MENOS:
      case VEZES:
      case DIVIDIDO:
      case ELEVADO:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_2;
      }
      operadorMatematico();
      expressaoLogica();
    }
  }

  static final public void expressaoLogica() throws ParseException {
    atribuivel();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IGUAL:
      case DIFERENTE:
      case MAIOR:
      case MENOR:
      case MAIOR_IGUAL:
      case MENOR_IGUAL:
      case OU:
      case E:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_3;
      }
      operadorLogico();
      atribuivel();
    }
  }

  static final public void atribuivel() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ABRE_PARENTESE:
      expressaoEntreParenteses();
      break;
    case MAIS:
    case MENOS:
    case NUMERO:
      numeroComSinal();
      break;
    case NOME_VARIAVEL:
      nomeVariavel();
      break;
    case TEXTO:
      jj_consume_token(TEXTO);
      break;
    case BOOLEANO:
      jj_consume_token(BOOLEANO);
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void expressaoEntreParenteses() throws ParseException {
    jj_consume_token(ABRE_PARENTESE);
    expressaoMatematica();
    jj_consume_token(FECHA_PARENTESE);
  }

  static final public void operadorMatematico() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MAIS:
      jj_consume_token(MAIS);
      break;
    case MENOS:
      jj_consume_token(MENOS);
      break;
    case VEZES:
      jj_consume_token(VEZES);
      break;
    case DIVIDIDO:
      jj_consume_token(DIVIDIDO);
      break;
    case ELEVADO:
      jj_consume_token(ELEVADO);
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void operadorLogico() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MAIOR:
      jj_consume_token(MAIOR);
      break;
    case MENOR:
      jj_consume_token(MENOR);
      break;
    case MAIOR_IGUAL:
      jj_consume_token(MAIOR_IGUAL);
      break;
    case MENOR_IGUAL:
      jj_consume_token(MENOR_IGUAL);
      break;
    case IGUAL:
      jj_consume_token(IGUAL);
      break;
    case DIFERENTE:
      jj_consume_token(DIFERENTE);
      break;
    case OU:
      jj_consume_token(OU);
      break;
    case E:
      jj_consume_token(E);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void declaracaoDeVariavel() throws ParseException {
    tipoDeDado();
    listaDeDeclaracao();
  }

  static final public void tipoDeDado() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case REDONDO:
      jj_consume_token(REDONDO);
      break;
    case QUEBRADO:
      jj_consume_token(QUEBRADO);
      break;
    case TROVA:
      jj_consume_token(TROVA);
      break;
    case LOGICO:
      jj_consume_token(LOGICO);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void listaDeDeclaracao() throws ParseException {
    nomeVariavel();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ATRIBUICAO:
      lacoDeAtribuicao();
      break;
    default:
      jj_la1[12] = jj_gen;
      ;
    }
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_4;
      }
      jj_consume_token(VIRGULA);
      nomeVariavel();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ATRIBUICAO:
        lacoDeAtribuicao();
        break;
      default:
        jj_la1[14] = jj_gen;
        ;
      }
    }
  }

  static final public void bloco() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LOQUEANDO:
      inicioLoqueando();
      break;
    case REPETECO:
      inicioRepeteco();
      break;
    case SE:
      inicioSe();
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void inicioLoqueando() throws ParseException {
    loqueando();
    expressaoMatematica();
    meioLoqueando();
  }

  static final public void meioLoqueando() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OPERACAO_DE_LINHA:
      inicioOperacaoLinha();
      linha();
      break;
    case INICIO_BLOCO:
      inicioBloco();
      fimLinha();
      blocoLoqueando();
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void blocoLoqueando() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FIM_LINHA:
    case REDONDO:
    case QUEBRADO:
    case TROVA:
    case LOGICO:
    case NOME_VARIAVEL:
      linha();
      blocoLoqueando();
      break;
    case LOQUEANDO:
    case REPETECO:
    case SE:
      bloco();
      blocoLoqueando();
      break;
    case FIM_BLOCO:
      fimBloco();
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void inicioRepeteco() throws ParseException {
    repeteco();
    nomeVariavel();
    minRepeteco();
    expressaoMatematica();
    maxRepeteco();
    expressaoMatematica();
    meioRepeteco();
  }

  static final public void meioRepeteco() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OPERACAO_DE_LINHA:
      inicioOperacaoLinha();
      linha();
      break;
    case INICIO_BLOCO:
      inicioBloco();
      fimLinha();
      blocoRepeteco();
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void blocoRepeteco() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FIM_LINHA:
    case REDONDO:
    case QUEBRADO:
    case TROVA:
    case LOGICO:
    case NOME_VARIAVEL:
      linha();
      blocoRepeteco();
      break;
    case LOQUEANDO:
    case REPETECO:
    case SE:
      bloco();
      blocoRepeteco();
      break;
    case FIM_BLOCO:
      fimBloco();
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void inicioSe() throws ParseException {
    se();
    expressaoMatematica();
    meioSe();
  }

  static final public void meioSe() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OPERACAO_DE_LINHA:
      inicioOperacaoLinha();
      linha();
      possivelLinhaSenao();
      break;
    case INICIO_BLOCO:
      inicioBloco();
      fimLinha();
      blocoSe();
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void possivelLinhaSenao() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SENAO:
      inicioSenao();
      break;
    default:
      jj_la1[21] = jj_gen;
      ;
    }
  }

                                   // LOOKAHEAD EXPLICITADO PARA DIZER AO COMPILADOR QUE SEI O QUE ESTOU FAZENDO
  static final public void blocoSe() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FIM_LINHA:
    case REDONDO:
    case QUEBRADO:
    case TROVA:
    case LOGICO:
    case NOME_VARIAVEL:
      linha();
      blocoSe();
      break;
    case LOQUEANDO:
    case REPETECO:
    case SE:
      bloco();
      blocoSe();
      break;
    case FIM_BLOCO:
      fimBloco();
      break;
    case SENAO:
      inicioSenao();
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void inicioSenao() throws ParseException {
    senao();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INICIO_BLOCO:
    case OPERACAO_DE_LINHA:
      meioSe();
      break;
    case SE:
      inicioSe();
      break;
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void fimDePrograma() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 0:
      jj_consume_token(0);
      break;
    case FIM_PROGRAMA:
      jj_consume_token(FIM_PROGRAMA);
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public LexerTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[25];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x98080000,0x98080000,0x30,0x30,0x0,0x80000,0x1f0,0x3fc00,0x2000030,0x1f0,0x3fc00,0x0,0x200,0x100000,0x200,0x98000000,0xa00000,0x98480000,0xa00000,0x98480000,0xa00000,0x0,0x98480000,0x80a00000,0x40001,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x9e,0x9e,0x0,0x0,0x9e,0x9e,0x0,0x0,0x50c0,0x0,0x0,0x1e,0x0,0x0,0x0,0x0,0x0,0x9e,0x0,0x9e,0x0,0x1,0x9f,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public Lexer(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Lexer(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new LexerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Lexer(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new LexerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Lexer(LexerTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(LexerTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[48];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 25; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 48; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
