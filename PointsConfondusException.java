package logicieldedessin;

public class PointsConfondusException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7004354477237085370L;
	
	public PointsConfondusException(Point p1, Point p2){ super("Erreur : " + p1.getNom() + "et" + p2.getNom() + "sont confondus !");}
}
