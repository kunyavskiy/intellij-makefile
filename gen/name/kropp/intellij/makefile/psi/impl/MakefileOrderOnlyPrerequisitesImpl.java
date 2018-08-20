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

public class MakefileOrderOnlyPrerequisitesImpl extends ASTWrapperPsiElement implements MakefileOrderOnlyPrerequisites {

  public MakefileOrderOnlyPrerequisitesImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MakefileVisitor visitor) {
    visitor.visitOrderOnlyPrerequisites(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MakefileVisitor) accept((MakefileVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MakefilePrerequisite> getPrerequisiteList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MakefilePrerequisite.class);
  }

}
