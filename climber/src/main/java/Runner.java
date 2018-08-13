import db.DBClimber;
import db.DBRoute;
import models.Climber;
import models.Route;

import java.util.List;

public class Runner {

	public static void main(String[] args) {

		Climber chrisSharma = new Climber("Chris Sharma", 40, "Strong and dynamic");
		DBClimber.save(chrisSharma);

		Climber hazelFinlay= new Climber("Hazel Finlay", 28, "Strong, technical and bold");
		DBClimber.save(hazelFinlay);


		Route dreamcatcher = new Route("Dreamcatcher", "5.14d", "Beautiful and hard");
		DBRoute.save(dreamcatcher);

		Route centuryCrack= new Route("Century Crack", "5.14b", "Hard and painful!");
		DBRoute.save(centuryCrack);

		List<Climber> climbers = DBClimber.getAll();
		List<Route> routes = DBRoute.getAll();

		Climber foundClimber = DBClimber.findById(2);
		Route routeFound = DBRoute.findById(2);
	}

}
