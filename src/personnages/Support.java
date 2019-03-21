package personnages;

public class Support extends Personnage {
	public Support() {
		super(100, 7, 4);
	}

	@Override
	public void useSkill(Personnage joueur) {
		int x;
		x = (int) (Math.random() * 10);
		if (x <= this.getCritique()) {
			this.setHp(this.getHp() + this.getStrength());
			joueur.setHp(joueur.getHp() + this.getStrength());
			if (joueur.getHp() >= joueur.getMaxHp())
				joueur.setHp(joueur.getMaxHp());
			if (this.getHp() >= this.getMaxHp())
				this.setHp(this.getMaxHp());
			if (joueur.getHp() >= joueur.getMaxHp())
				joueur.setHp(joueur.getMaxHp());
			if (this.getHp() >= this.getMaxHp())
				this.setHp(this.getMaxHp());
			System.out.println("Laya vous a soigné et s'est également soignée");
		}

	}
}
