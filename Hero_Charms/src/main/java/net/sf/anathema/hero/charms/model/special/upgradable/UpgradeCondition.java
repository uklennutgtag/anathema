package net.sf.anathema.hero.charms.model.special.upgradable;

import net.sf.anathema.character.main.magic.charm.Charm;
import net.sf.anathema.character.main.magic.charm.ICharmLearnableArbitrator;
import net.sf.anathema.hero.charms.model.special.CharmSpecialist;
import net.sf.anathema.character.main.traits.TraitType;
import net.sf.anathema.character.main.traits.types.OtherTraitType;
import net.sf.anathema.hero.traits.TraitModel;
import net.sf.anathema.lib.data.Condition;

public class UpgradeCondition implements Condition {
  private final ICharmLearnableArbitrator arbitrator;
  private final Charm charm;
  private final boolean bpUpgradeAllowed;
  private CharmSpecialist specialist;
  private final Integer essenceMin;
  private final Integer traitMin;
  private final TraitType trait;

  public UpgradeCondition(ICharmLearnableArbitrator arbitrator, Charm charm, boolean bpUpgradeAllowed, CharmSpecialist specialist,
                          Integer essenceMin, Integer traitMin, TraitType trait) {
    this.arbitrator = arbitrator;
    this.charm = charm;
    this.bpUpgradeAllowed = bpUpgradeAllowed;
    this.specialist = specialist;
    this.essenceMin = essenceMin;
    this.traitMin = traitMin;
    this.trait = trait;
  }

  @Override
  public boolean isFulfilled() {
    boolean learnable = arbitrator.isLearnable(charm) && (bpUpgradeAllowed || specialist.getExperience().isExperienced());
    TraitModel traits = specialist.getTraits();
    int essenceValue = traits.getTrait(OtherTraitType.Essence).getCurrentValue();
    learnable = !learnable ? learnable : (essenceMin == null || essenceValue >= essenceMin);
    int traitValue = traits.getTrait(trait).getCurrentValue();
    return !learnable ? learnable : (traitMin == null || trait == null || traitValue >= essenceMin);
  }
}
