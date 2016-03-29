package xmlGenerator;

import xmlGenerator.GUI.GUIXmlGenerator;

public class XmlGenerator {

	private GUIXmlGenerator guiXmlGnerator;

	public void GUIAssociation(GUIXmlGenerator gui) {
		this.setGuiXmlGnerator(gui);

	}

	public GUIXmlGenerator getGuiXmlGnerator() {
		return guiXmlGnerator;
	}

	public void setGuiXmlGnerator(GUIXmlGenerator guiXmlGnerator) {
		this.guiXmlGnerator = guiXmlGnerator;
	}

}
