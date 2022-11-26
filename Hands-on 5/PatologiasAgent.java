/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examples.clips.agents;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import net.sf.clipsrules.jni.*;

/**
 *
 * @author chiva
 */
public class PatologiasAgent extends Agent {
     Environment clips;
         boolean tellDone = false;
         
    protected void setup() {
        try {
            clips = new Environment();
        } catch (Exception e) {
        }
        addBehaviour(new TellBehaviour());
        addBehaviour(new AskBehaviour());
    }
        private class TellBehaviour extends Behaviour {
        boolean tellDone = false;
        public void action() {
            System.out.println("Tell es ejecutado");
            try {
                clips.clear();
                clips.load("src/clips/patologias/templates.clp");
                clips.load("src/clips/patologias/facts.clp");
                clips.load("src/clips/patologias/rules.clp");
                clips.reset();
                clips.eval("(facts)");
            } catch (Exception e) {
            }
            tellDone = true;
        }
        public boolean done(){
            if(tellDone)
                return true;
            else
                return false;
        }
    }
                private class AskBehaviour extends Behaviour {

            boolean askDone = false;

            public void action() {
                System.out.println("Ask es ejecutado");
                try {
                    clips.run();
                    clips.clear();
                } catch (Exception e) {
                }
                askDone = true;
            }
            public boolean done() {
                if (askDone) {
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
