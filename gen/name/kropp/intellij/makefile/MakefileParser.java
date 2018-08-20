// This is a generated file. Not intended for manual editing.
package name.kropp.intellij.makefile;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static name.kropp.intellij.makefile.psi.MakefileTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MakefileParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == BLOCK) {
      r = block(b, 0);
    }
    else if (t == COMMAND) {
      r = command(b, 0);
    }
    else if (t == COMMENT) {
      r = comment(b, 0);
    }
    else if (t == CONDITIONAL) {
      r = conditional(b, 0);
    }
    else if (t == DEFINE) {
      r = define(b, 0);
    }
    else if (t == DIRECTORY) {
      r = directory(b, 0);
    }
    else if (t == DOC_COMMENT) {
      r = doc_comment(b, 0);
    }
    else if (t == EMPTY_COMMAND) {
      r = empty_command(b, 0);
    }
    else if (t == EXPORT) {
      r = export(b, 0);
    }
    else if (t == FILENAME) {
      r = filename(b, 0);
    }
    else if (t == FUNCTION) {
      r = function(b, 0);
    }
    else if (t == FUNCTION_NAME) {
      r = function_name(b, 0);
    }
    else if (t == INCLUDE) {
      r = include(b, 0);
    }
    else if (t == NORMAL_PREREQUISITES) {
      r = normal_prerequisites(b, 0);
    }
    else if (t == ORDER_ONLY_PREREQUISITES) {
      r = order_only_prerequisites(b, 0);
    }
    else if (t == OVERRIDE) {
      r = override(b, 0);
    }
    else if (t == PATTERN) {
      r = pattern(b, 0);
    }
    else if (t == PREREQUISITE) {
      r = prerequisite(b, 0);
    }
    else if (t == PREREQUISITES) {
      r = prerequisites(b, 0);
    }
    else if (t == PRIVATEVAR) {
      r = privatevar(b, 0);
    }
    else if (t == RECIPE) {
      r = recipe(b, 0);
    }
    else if (t == RULE) {
      r = rule(b, 0);
    }
    else if (t == TARGET) {
      r = target(b, 0);
    }
    else if (t == TARGET_LINE) {
      r = target_line(b, 0);
    }
    else if (t == TARGET_PATTERN) {
      r = target_pattern(b, 0);
    }
    else if (t == TARGETS) {
      r = targets(b, 0);
    }
    else if (t == UNDEFINE) {
      r = undefine(b, 0);
    }
    else if (t == VARIABLE) {
      r = variable(b, 0);
    }
    else if (t == VPATH) {
      r = vpath(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return makefile(b, l + 1);
  }

  /* ********************************************************** */
  // conditional|rule|command|variable-assignment|directive|function|macro
  static boolean any(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "any")) return false;
    boolean r;
    r = conditional(b, l + 1);
    if (!r) r = rule(b, l + 1);
    if (!r) r = command(b, l + 1);
    if (!r) r = variable_assignment(b, l + 1);
    if (!r) r = directive(b, l + 1);
    if (!r) r = function(b, l + 1);
    if (!r) r = consumeToken(b, MACRO);
    return r;
  }

  /* ********************************************************** */
  // '='|':='|'::='|'?='|'!='|'+='
  static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    if (!r) r = consumeToken(b, ":=");
    if (!r) r = consumeToken(b, "::=");
    if (!r) r = consumeToken(b, "?=");
    if (!r) r = consumeToken(b, "!=");
    if (!r) r = consumeToken(b, "+=");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // any+|empty_command?
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK, "<block>");
    r = block_0(b, l + 1);
    if (!r) r = block_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // any+
  private static boolean block_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = any(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!any(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // empty_command?
  private static boolean block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_1")) return false;
    empty_command(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '\t'* multiline
  public static boolean command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMAND, "<command>");
    r = command_0(b, l + 1);
    r = r && multiline(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '\t'*
  private static boolean command_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "command_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, TAB)) break;
      if (!empty_element_parsed_guard_(b, "command_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  public static boolean comment(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, COMMENT, true);
    return true;
  }

  /* ********************************************************** */
  // conditional-keyword condition block ('else' (conditional-keyword condition block | EOL block))* 'endif'
  public static boolean conditional(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL, "<conditional>");
    r = conditional_keyword(b, l + 1);
    r = r && consumeToken(b, CONDITION);
    r = r && block(b, l + 1);
    r = r && conditional_3(b, l + 1);
    r = r && consumeToken(b, KEYWORD_ENDIF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('else' (conditional-keyword condition block | EOL block))*
  private static boolean conditional_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!conditional_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "conditional_3", c)) break;
    }
    return true;
  }

  // 'else' (conditional-keyword condition block | EOL block)
  private static boolean conditional_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KEYWORD_ELSE);
    r = r && conditional_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // conditional-keyword condition block | EOL block
  private static boolean conditional_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_3_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = conditional_3_0_1_0(b, l + 1);
    if (!r) r = conditional_3_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // conditional-keyword condition block
  private static boolean conditional_3_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_3_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = conditional_keyword(b, l + 1);
    r = r && consumeToken(b, CONDITION);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EOL block
  private static boolean conditional_3_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_3_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EOL);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'ifeq'|'ifneq'|'ifdef'|'ifndef'
  static boolean conditional_keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_keyword")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KEYWORD_IFEQ);
    if (!r) r = consumeToken(b, KEYWORD_IFNEQ);
    if (!r) r = consumeToken(b, KEYWORD_IFDEF);
    if (!r) r = consumeToken(b, KEYWORD_IFNDEF);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'define' variable assignment? (variable-value-line split?)* 'endef'
  public static boolean define(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define")) return false;
    if (!nextTokenIs(b, KEYWORD_DEFINE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DEFINE, null);
    r = consumeToken(b, KEYWORD_DEFINE);
    p = r; // pin = 1
    r = r && report_error_(b, variable(b, l + 1));
    r = p && report_error_(b, define_2(b, l + 1)) && r;
    r = p && report_error_(b, define_3(b, l + 1)) && r;
    r = p && consumeToken(b, KEYWORD_ENDEF) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // assignment?
  private static boolean define_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_2")) return false;
    assignment(b, l + 1);
    return true;
  }

  // (variable-value-line split?)*
  private static boolean define_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!define_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "define_3", c)) break;
    }
    return true;
  }

  // variable-value-line split?
  private static boolean define_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VARIABLE_VALUE_LINE);
    r = r && define_3_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // split?
  private static boolean define_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_3_0_1")) return false;
    consumeToken(b, SPLIT);
    return true;
  }

  /* ********************************************************** */
  // define|include|undefine|override|export|privatevar|vpath
  static boolean directive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive")) return false;
    boolean r;
    r = define(b, l + 1);
    if (!r) r = include(b, l + 1);
    if (!r) r = undefine(b, l + 1);
    if (!r) r = override(b, l + 1);
    if (!r) r = export(b, l + 1);
    if (!r) r = privatevar(b, l + 1);
    if (!r) r = vpath(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean directory(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directory")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, DIRECTORY, r);
    return r;
  }

  /* ********************************************************** */
  public static boolean doc_comment(PsiBuilder b, int l) {
    Marker m = enter_section_(b);
    exit_section_(b, m, DOC_COMMENT, true);
    return true;
  }

  /* ********************************************************** */
  // '\t'+
  public static boolean empty_command(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "empty_command")) return false;
    if (!nextTokenIs(b, TAB)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TAB);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, TAB)) break;
      if (!empty_element_parsed_guard_(b, "empty_command", c)) break;
    }
    exit_section_(b, m, EMPTY_COMMAND, r);
    return r;
  }

  /* ********************************************************** */
  // 'export' (variable-assignment|variable)? EOL
  public static boolean export(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "export")) return false;
    if (!nextTokenIs(b, KEYWORD_EXPORT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, EXPORT, null);
    r = consumeToken(b, KEYWORD_EXPORT);
    p = r; // pin = 1
    r = r && report_error_(b, export_1(b, l + 1));
    r = p && consumeToken(b, EOL) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (variable-assignment|variable)?
  private static boolean export_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "export_1")) return false;
    export_1_0(b, l + 1);
    return true;
  }

  // variable-assignment|variable
  private static boolean export_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "export_1_0")) return false;
    boolean r;
    r = variable_assignment(b, l + 1);
    if (!r) r = variable(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'export' variable-assignment
  static boolean exportvar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exportvar")) return false;
    if (!nextTokenIs(b, KEYWORD_EXPORT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, KEYWORD_EXPORT);
    p = r; // pin = 1
    r = r && variable_assignment(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // identifier
  public static boolean filename(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filename")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, FILENAME, r);
    return r;
  }

  /* ********************************************************** */
  // function-name function-param* FUNCTION_END
  public static boolean function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function")) return false;
    if (!nextTokenIs(b, FUNCTION_NAME_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function_name(b, l + 1);
    r = r && function_1(b, l + 1);
    r = r && consumeToken(b, FUNCTION_END);
    exit_section_(b, m, FUNCTION, r);
    return r;
  }

  // function-param*
  private static boolean function_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!function_param(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "function_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // function-name-token
  public static boolean function_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_name")) return false;
    if (!nextTokenIs(b, FUNCTION_NAME_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNCTION_NAME_TOKEN);
    exit_section_(b, m, FUNCTION_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // function-param-text|variable_usage
  public static boolean function_param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_param")) return false;
    if (!nextTokenIs(b, "", FUNCTION_PARAM_TEXT, VARIABLE_USAGE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNCTION_PARAM_TEXT);
    if (!r) r = consumeToken(b, VARIABLE_USAGE);
    exit_section_(b, m, FUNCTION_PARAM, r);
    return r;
  }

  /* ********************************************************** */
  // ('include'|'-include'|'sinclude') filename+ EOL
  public static boolean include(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INCLUDE, "<include>");
    r = include_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, include_1(b, l + 1));
    r = p && consumeToken(b, EOL) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // 'include'|'-include'|'sinclude'
  private static boolean include_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KEYWORD_INCLUDE);
    if (!r) r = consumeToken(b, "-include");
    if (!r) r = consumeToken(b, "sinclude");
    exit_section_(b, m, null, r);
    return r;
  }

  // filename+
  private static boolean include_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = filename(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!filename(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "include_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // any*
  static boolean makefile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "makefile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!any(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "makefile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // line (split line?)* | (split line?)+
  static boolean multiline(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline")) return false;
    if (!nextTokenIs(b, "", LINE, SPLIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiline_0(b, l + 1);
    if (!r) r = multiline_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // line (split line?)*
  private static boolean multiline_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINE);
    r = r && multiline_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (split line?)*
  private static boolean multiline_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multiline_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiline_0_1", c)) break;
    }
    return true;
  }

  // split line?
  private static boolean multiline_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SPLIT);
    r = r && multiline_0_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // line?
  private static boolean multiline_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_0_1_0_1")) return false;
    consumeToken(b, LINE);
    return true;
  }

  // (split line?)+
  private static boolean multiline_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiline_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!multiline_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiline_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // split line?
  private static boolean multiline_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SPLIT);
    r = r && multiline_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // line?
  private static boolean multiline_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_1_0_1")) return false;
    consumeToken(b, LINE);
    return true;
  }

  /* ********************************************************** */
  // prerequisite* (split prerequisite*)*
  public static boolean normal_prerequisites(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_prerequisites")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NORMAL_PREREQUISITES, "<normal prerequisites>");
    r = normal_prerequisites_0(b, l + 1);
    r = r && normal_prerequisites_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // prerequisite*
  private static boolean normal_prerequisites_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_prerequisites_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!prerequisite(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "normal_prerequisites_0", c)) break;
    }
    return true;
  }

  // (split prerequisite*)*
  private static boolean normal_prerequisites_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_prerequisites_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!normal_prerequisites_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "normal_prerequisites_1", c)) break;
    }
    return true;
  }

  // split prerequisite*
  private static boolean normal_prerequisites_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_prerequisites_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SPLIT);
    r = r && normal_prerequisites_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // prerequisite*
  private static boolean normal_prerequisites_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normal_prerequisites_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!prerequisite(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "normal_prerequisites_1_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // prerequisite* (split prerequisite*)*
  public static boolean order_only_prerequisites(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "order_only_prerequisites")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ORDER_ONLY_PREREQUISITES, "<order only prerequisites>");
    r = order_only_prerequisites_0(b, l + 1);
    r = r && order_only_prerequisites_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // prerequisite*
  private static boolean order_only_prerequisites_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "order_only_prerequisites_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!prerequisite(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "order_only_prerequisites_0", c)) break;
    }
    return true;
  }

  // (split prerequisite*)*
  private static boolean order_only_prerequisites_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "order_only_prerequisites_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!order_only_prerequisites_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "order_only_prerequisites_1", c)) break;
    }
    return true;
  }

  // split prerequisite*
  private static boolean order_only_prerequisites_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "order_only_prerequisites_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SPLIT);
    r = r && order_only_prerequisites_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // prerequisite*
  private static boolean order_only_prerequisites_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "order_only_prerequisites_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!prerequisite(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "order_only_prerequisites_1_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'override' variable-assignment
  public static boolean override(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "override")) return false;
    if (!nextTokenIs(b, KEYWORD_OVERRIDE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OVERRIDE, null);
    r = consumeToken(b, KEYWORD_OVERRIDE);
    p = r; // pin = 1
    r = r && variable_assignment(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // identifier
  public static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, PATTERN, r);
    return r;
  }

  /* ********************************************************** */
  // identifier|variable_usage
  public static boolean prerequisite(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prerequisite")) return false;
    if (!nextTokenIs(b, "<prerequisite>", IDENTIFIER, VARIABLE_USAGE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREREQUISITE, "<prerequisite>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, VARIABLE_USAGE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // normal_prerequisites ('|' order_only_prerequisites)?
  public static boolean prerequisites(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prerequisites")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREREQUISITES, "<prerequisites>");
    r = normal_prerequisites(b, l + 1);
    r = r && prerequisites_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('|' order_only_prerequisites)?
  private static boolean prerequisites_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prerequisites_1")) return false;
    prerequisites_1_0(b, l + 1);
    return true;
  }

  // '|' order_only_prerequisites
  private static boolean prerequisites_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prerequisites_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PIPE);
    r = r && order_only_prerequisites(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'private' variable-assignment
  public static boolean privatevar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "privatevar")) return false;
    if (!nextTokenIs(b, KEYWORD_PRIVATE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PRIVATEVAR, null);
    r = consumeToken(b, KEYWORD_PRIVATE);
    p = r; // pin = 1
    r = r && variable_assignment(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // (command|conditional|empty_command)*
  public static boolean recipe(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recipe")) return false;
    Marker m = enter_section_(b, l, _NONE_, RECIPE, "<recipe>");
    while (true) {
      int c = current_position_(b);
      if (!recipe_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "recipe", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // command|conditional|empty_command
  private static boolean recipe_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recipe_0")) return false;
    boolean r;
    r = command(b, l + 1);
    if (!r) r = conditional(b, l + 1);
    if (!r) r = empty_command(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // target_line recipe
  public static boolean rule(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule")) return false;
    if (!nextTokenIs(b, "<rule>", IDENTIFIER, VARIABLE_USAGE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RULE, "<rule>");
    r = target_line(b, l + 1);
    r = r && recipe(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier|variable_usage
  public static boolean target(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target")) return false;
    if (!nextTokenIs(b, "<target>", IDENTIFIER, VARIABLE_USAGE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TARGET, "<target>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, VARIABLE_USAGE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // targets (':'|'::') (target_pattern ':')? (exportvar|override|privatevar|variable-assignment|prerequisites ';'? EOL?)
  public static boolean target_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_line")) return false;
    if (!nextTokenIs(b, "<target line>", IDENTIFIER, VARIABLE_USAGE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TARGET_LINE, "<target line>");
    r = targets(b, l + 1);
    r = r && target_line_1(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, target_line_2(b, l + 1));
    r = p && target_line_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ':'|'::'
  private static boolean target_line_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_line_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, DOUBLECOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // (target_pattern ':')?
  private static boolean target_line_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_line_2")) return false;
    target_line_2_0(b, l + 1);
    return true;
  }

  // target_pattern ':'
  private static boolean target_line_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_line_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = target_pattern(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // exportvar|override|privatevar|variable-assignment|prerequisites ';'? EOL?
  private static boolean target_line_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_line_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = exportvar(b, l + 1);
    if (!r) r = override(b, l + 1);
    if (!r) r = privatevar(b, l + 1);
    if (!r) r = variable_assignment(b, l + 1);
    if (!r) r = target_line_3_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // prerequisites ';'? EOL?
  private static boolean target_line_3_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_line_3_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prerequisites(b, l + 1);
    r = r && target_line_3_4_1(b, l + 1);
    r = r && target_line_3_4_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ';'?
  private static boolean target_line_3_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_line_3_4_1")) return false;
    consumeToken(b, SEMICOLON);
    return true;
  }

  // EOL?
  private static boolean target_line_3_4_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_line_3_4_2")) return false;
    consumeToken(b, EOL);
    return true;
  }

  /* ********************************************************** */
  // identifier
  public static boolean target_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "target_pattern")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, TARGET_PATTERN, r);
    return r;
  }

  /* ********************************************************** */
  // target+
  public static boolean targets(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "targets")) return false;
    if (!nextTokenIs(b, "<targets>", IDENTIFIER, VARIABLE_USAGE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TARGETS, "<targets>");
    r = target(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!target(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "targets", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'undefine' variable EOL
  public static boolean undefine(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "undefine")) return false;
    if (!nextTokenIs(b, KEYWORD_UNDEFINE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNDEFINE, null);
    r = consumeToken(b, KEYWORD_UNDEFINE);
    p = r; // pin = 1
    r = r && report_error_(b, variable(b, l + 1));
    r = p && consumeToken(b, EOL) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // identifier
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VARIABLE, r);
    return r;
  }

  /* ********************************************************** */
  // variable assignment (function|variable-value?)
  public static boolean variable_assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_assignment")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_ASSIGNMENT, null);
    r = variable(b, l + 1);
    r = r && assignment(b, l + 1);
    p = r; // pin = 2
    r = r && variable_assignment_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // function|variable-value?
  private static boolean variable_assignment_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_assignment_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function(b, l + 1);
    if (!r) r = variable_assignment_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // variable-value?
  private static boolean variable_assignment_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_assignment_2_1")) return false;
    variable_value(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // multiline
  public static boolean variable_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_value")) return false;
    if (!nextTokenIs(b, "", LINE, SPLIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiline(b, l + 1);
    exit_section_(b, m, VARIABLE_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // 'vpath' (pattern directory*)? EOL
  public static boolean vpath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vpath")) return false;
    if (!nextTokenIs(b, KEYWORD_VPATH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VPATH, null);
    r = consumeToken(b, KEYWORD_VPATH);
    p = r; // pin = 1
    r = r && report_error_(b, vpath_1(b, l + 1));
    r = p && consumeToken(b, EOL) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (pattern directory*)?
  private static boolean vpath_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vpath_1")) return false;
    vpath_1_0(b, l + 1);
    return true;
  }

  // pattern directory*
  private static boolean vpath_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vpath_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pattern(b, l + 1);
    r = r && vpath_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // directory*
  private static boolean vpath_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vpath_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!directory(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "vpath_1_0_1", c)) break;
    }
    return true;
  }

}
