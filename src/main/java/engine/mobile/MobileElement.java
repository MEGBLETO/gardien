package engine.mobile;

import engine.map.Block;

public abstract class MobileElement {
	private Block position;

	public MobileElement(Block position) {
		this.position = position;
	}

	public Block getPosition() {

		System.out.println(position);
		return position;
	}

	public void setPosition(Block position) {
		this.position = position;
	}

}
