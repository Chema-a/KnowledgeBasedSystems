/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examples.clips.agents;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import net.sf.clipsrules.jni.*;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author chiva
 */
public class ChiefSurgeonAgent extends Agent {

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
                    clips.assertString("(patient ready)");
                    clips.load(msg.getContent());
                    clips.eval("(rules)");
                    clips.eval("(facts)");
                    clips.run();

                    ACLMessage msg1 = new ACLMessage(ACLMessage.INFORM);
                    msg1.setContent("src/clips/surgery/rules_anesthesiologist.clp");
                    msg1.addReceiver(new AID("anesthesiologist",AID.ISLOCALNAME));
                    send(msg1);
                    
                } else {
                    block();
                }

            }
        });
    }
}
