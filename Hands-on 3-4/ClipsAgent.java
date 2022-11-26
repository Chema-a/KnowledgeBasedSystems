package clips.agents;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.clipsrules.jni.*;

public class ClipsAgent extends Agent {

    private Environment clips;

    protected void setup() {
        clips = new Environment();
        addBehaviour(new Persons());
        addBehaviour(new Prodcust());
        addBehaviour(new Market());
    }

    private class Persons extends Behaviour {

        boolean tellDone = false;

        public void action() {

            try {
                System.out.println("Leyendo... [PERSONS]");
                clips.load("persons/load-persons.clp");
                clips.load("persons/load-persons-rules.clp");

                clips.eval("(reset)");
                clips.eval("(rules)");
                clips.eval("(facts)");
                System.out.println("----------------------------------");
                clips.eval("(clear)");


                /*System.out.println("Invoking Tell");
            clips.eval("(clear)");
            clips.build("(defrule r1 (sintoma ?s) => (printout t ?s crlf))");
            clips.eval("(reset)");
            
            clips.eval("(assert (sintoma a))");*/
                tellDone = true;
            } catch (CLIPSException ex) {
                Logger.getLogger(ClipsAgent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public boolean done() {
            if (tellDone) {
                return true;
            } else {
                return false;
            }
        }
    }    // END of inner class ...Behaviour

    private class Prodcust extends Behaviour {

        boolean prodDone = false;

        public void action() {
            try {
                System.out.println("Leyendo... [PRODCUST]");
                clips.load("prodcust/load-prod-cust.clp");
                clips.load("prodcust/load-prodcust-rules.clp");
                clips.eval("(reset)");
                clips.eval("(rules)");
                clips.eval("(facts)");
                System.out.println("----------------------------------");
                clips.eval("(clear)");

                prodDone = true;
            } catch (CLIPSException ex) {
                Logger.getLogger(ClipsAgent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public boolean done() {
            if (prodDone) {
                return true;
            } else {
                return false;
            }
        }
    }

    private class Market extends Behaviour {

        boolean marDone = false;

        public void action() {
            try{
            System.out.println("Leyendo... [PRODCUST]");
            clips.load("market/facts.clp");
            clips.load("market/rules.clp");
            clips.eval("(reset)");
            clips.eval("(rules)");
            clips.eval("(facts)");
            System.out.println("----------------------------------");
            clips.eval("(clear)");
            //clips.clear();
            //System.out.println("Invoking Ask");
            marDone = true;
             } catch (CLIPSException ex) {
                Logger.getLogger(ClipsAgent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public boolean done() {
            if (marDone) {
                return true;
            } else {
                return false;
            }
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    }
}