// This is a generated file. Not intended for manual editing.
package name.kropp.intellij.makefile.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static name.kropp.intellij.makefile.psi.MakefileTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import name.kropp.intellij.makefile.psi.*;

public class MakefileVariableAssignmentImpl extends ASTWrapperPsiElement implements MakefileVariableAssignment {

  public MakefileVariableAssignmentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MakefileVisitor visitor) {
    visitor.visitVariableAssignment(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MakefileVisitor) accept((MakefileVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MakefileFunction getFunction() {
    return findChildByClass(MakefileFunction.class);
  }

  @Override
  @NotNull
  public MakefileVariable getVariable() {
    return findNotNullChildByClass(MakefileVariable.class);
  }

  @Override
  @Nullable
  public MakefileVariableValue getVariableValue() {
    return findChildByClass(MakefileVariableValue.class);
  }

  @Nullable
  public PsiElement getAssignment() {
    return MakefilePsiImplUtil.getAssignment(this);
  }

  @Nullable
  public String getValue() {
    return MakefilePsiImplUtil.getValue(this);
  }

}
