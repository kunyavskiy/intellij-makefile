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

public class MakefileTargetLineImpl extends ASTWrapperPsiElement implements MakefileTargetLine {

  public MakefileTargetLineImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MakefileVisitor visitor) {
    visitor.visitTargetLine(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MakefileVisitor) accept((MakefileVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MakefileOverride getOverride() {
    return findChildByClass(MakefileOverride.class);
  }

  @Override
  @Nullable
  public MakefilePrerequisites getPrerequisites() {
    return findChildByClass(MakefilePrerequisites.class);
  }

  @Override
  @Nullable
  public MakefilePrivatevar getPrivatevar() {
    return findChildByClass(MakefilePrivatevar.class);
  }

  @Override
  @Nullable
  public MakefileTargetPattern getTargetPattern() {
    return findChildByClass(MakefileTargetPattern.class);
  }

  @Override
  @NotNull
  public MakefileTargets getTargets() {
    return findNotNullChildByClass(MakefileTargets.class);
  }

  @Override
  @Nullable
  public MakefileVariableAssignment getVariableAssignment() {
    return findChildByClass(MakefileVariableAssignment.class);
  }

  @Nullable
  public String getTargetName() {
    return MakefilePsiImplUtil.getTargetName(this);
  }

}
