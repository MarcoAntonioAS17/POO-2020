package mx.uv.fiee.iinf.poo.setimplementations;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main (String [] args) {

        Set<String> soccerTeams = new LinkedHashSet<>(5, 0.6f);
        soccerTeams.add ("Liverpool");
        soccerTeams.add ("Manchester United");
        soccerTeams.add ("Barcelona");
        soccerTeams.add ("Real Madrid");
        soccerTeams.add ("Milan");
        soccerTeams.add ("Juventus");

        for (String team: soccerTeams) {
            System.out.println (team);
        }

    }

}
