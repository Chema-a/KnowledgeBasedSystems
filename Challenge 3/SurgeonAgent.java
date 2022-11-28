/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examples.clips.agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import net.sf.clipsrules.jni.*;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author chiva
 */
public class SurgeonAgent extends Agent {

    Environment clips;
    protected void setup() {
        try {
            clips = new Environment();
        } catch (Exception e) {
        }
        addBehaviour(new CyclicBehaviour() {
            
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    clips.clear();
                    clips.assertString("(patient anesthetized)");
                    clips.load(msg.getContent());
                    clips.eval("(rules)");
                    clips.eval("(facts)");
                    clips.run();
                    
                } else {
                    block();
                }

            }
        });
    }
}
