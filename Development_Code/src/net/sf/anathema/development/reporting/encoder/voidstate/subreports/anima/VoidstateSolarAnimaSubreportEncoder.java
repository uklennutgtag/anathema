package net.sf.anathema.development.reporting.encoder.voidstate.subreports.anima;

import java.util.Map;

import net.sf.anathema.character.generic.type.CharacterType;
import net.sf.anathema.development.reporting.encoder.AbstractPagedCharacterSheetEncoder;
import net.sf.anathema.development.reporting.encoder.ICharacterSheetPageEncoder;
import net.sf.anathema.development.reporting.encoder.voidstate.columns.IOneColumnEncoder;
import net.sf.anathema.development.reporting.encoder.voidstate.util.SubreportUtilities;
import net.sf.anathema.initialization.InitializationException;

public class VoidstateSolarAnimaSubreportEncoder extends AbstractPagedCharacterSheetEncoder {

  private IOneColumnEncoder columnEncoder;

  public VoidstateSolarAnimaSubreportEncoder(IOneColumnEncoder columnEncoder) throws InitializationException {
    super(SubreportUtilities.createPageFormat(AbstractVoidstateAnimaPageEncoder.calculateBounds()));
    this.columnEncoder = columnEncoder;
  }

  @Override
  protected ICharacterSheetPageEncoder[] getPageEncoders() {
    return new ICharacterSheetPageEncoder[] { new VoidstateSolarAnimaPageEncoder(columnEncoder) };
  }

  @Override
  protected void addParameterClasses(Map<String, String> parameterClasses) {
    // Nothing to do
  }

  @Override
  protected String getReportName() {
    return "VoidState" + CharacterType.SOLAR.name() + "AnimaSubreport";
  }
}