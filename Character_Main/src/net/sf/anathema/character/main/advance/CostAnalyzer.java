package net.sf.anathema.character.main.advance;

import net.sf.anathema.character.main.magic.MartialArtsUtilities;
import net.sf.anathema.character.main.magic.ICharm;
import net.sf.anathema.character.main.magic.IMagic;
import net.sf.anathema.character.main.magic.charms.MartialArtsLevel;
import net.sf.anathema.character.main.template.experience.ICostAnalyzer;
import net.sf.anathema.character.main.traits.types.AbilityType;
import net.sf.anathema.hero.traits.TraitMap;
import net.sf.anathema.hero.traits.TraitModelFetcher;
import net.sf.anathema.hero.model.Hero;

public class CostAnalyzer implements ICostAnalyzer {

  private final Hero hero;
  private final TraitMap traitCollection;

  public CostAnalyzer(Hero hero) {
    this.hero = hero;
    this.traitCollection = TraitModelFetcher.fetch(hero);
  }

  @Override
  public final boolean isOccultFavored() {
    return traitCollection.getTrait(AbilityType.Occult).isCasteOrFavored();
  }

  @Override
  public final boolean isMagicFavored(IMagic magic) {
    return magic.isFavored(hero);
  }

  @Override
  public MartialArtsLevel getMartialArtsLevel(ICharm charm) {
    return MartialArtsUtilities.getLevel(charm);
  }
}