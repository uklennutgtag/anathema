package net.sf.anathema.hero.charms.model;

import net.sf.anathema.character.main.magic.model.charm.Charm;

public interface MartialArtsCharmConfiguration {

  Charm[] getLearnedCharms();

  String[] getIncompleteCelestialMartialArtsGroups();

  String[] getCompleteCelestialMartialArtsGroups();

  boolean isAnyCelestialStyleCompleted();
}