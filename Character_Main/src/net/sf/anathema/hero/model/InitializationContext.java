package net.sf.anathema.hero.model;

import net.sf.anathema.character.generic.impl.magic.persistence.ISpellCache;
import net.sf.anathema.character.generic.impl.template.magic.ICharmProvider;
import net.sf.anathema.character.generic.template.ITemplateRegistry;
import net.sf.anathema.character.generic.type.CharacterTypes;

public interface InitializationContext {

  CharacterTypes getCharacterTypes();

  ITemplateRegistry getTemplateRegistry();

  ICharmProvider getCharmProvider();

  ISpellCache getSpellCache();
}
