package net.sf.anathema.character.library.trait;

import net.sf.anathema.character.generic.framework.additionaltemplate.model.IModifiableBasicTrait;
import net.sf.anathema.character.library.trait.subtrait.ISubTraitContainer;
import net.sf.anathema.lib.control.change.IChangeListener;

public interface IModifiableTrait extends ITrait, IModifiableBasicTrait, IModifiableGenericTrait {

  public int getMinimalValue();

  public void resetCurrentValue();

  public void setModifiedCreationRange(int newInitialValue, int newUpperValue);

  public void addRangeListener(IChangeListener listener);

  public ISubTraitContainer createSpecialtiesContainer();
}