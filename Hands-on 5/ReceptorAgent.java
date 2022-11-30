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
public class ReceptorAgent extends Agent {
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
                    clips.load("src/clips/patologias/templates.clp");
                    String message = msg.getContent();
                    clips.assertString(message);
                    clips.run();
                    clips.load("src/clips/patologias/rules.clp");
                    clips.eval("(facts)");
                    clips.eval("(rules)");
                    clips.run();
                    clips.clear();
                    
                } else {
                    System.out.println("El doctor está esperando pacientes");

                    block();
                }

            }
        });
    }
    
}
