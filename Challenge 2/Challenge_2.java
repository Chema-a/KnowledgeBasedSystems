/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examples.clips;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import net.sf.clipsrules.jni.Environment;

/**
 *
 * @author chiva
 */
public class Challenge_2 extends Agent {

    Environment clips;

    protected void setup() {
        try {
            clips = new Environment();
        } catch (Exception e) {
        }
        addBehaviour(new TellBehaviour());
        addBehaviour(new AskBehaviour());
    }

    /**
     * @param args the command line arguments
     */
    private class TellBehaviour extends Behaviour {

        boolean tellDone = false;
        @Override
        public void action() {
            System.out.println("Tell es ejecutado");
            try {
                clips.clear();
                clips.load("src/clips/market/templates.clp");
                clips.load("src/clips/market/facts.clp");
                clips.load("src/clips/market/rules.clp");
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
            @Override
            public void action() {
                System.out.println("Ask es ejecutado");
                try {
                    clips.run();
                    clips.clear();
                } catch (Exception e) {
                }
                askDone = true;
            }
            @Override
            public boolean done() {
                if (askDone) {
                    return true;
                } else {
                    return false;
                }

            }
            @Override
            public int onEnd() {
                myAgent.doDelete();
                return super.onEnd();
            }
        }
    }
