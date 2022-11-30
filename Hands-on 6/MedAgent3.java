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
public class MedAgent3 extends Agent{
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
                        clips.load("src/clips/patologias2/dermatologo/templates.clp");
                        clips.load(msg.getContent());
                        clips.load("src/clips/patologias2/dermatologo/rules.clp");
                        clips.reset();

                        clips.run();
                        clips.clear();
                        
                    } else {
                        System.out.println("El dermatologo está esperando pacientes");
                        block();
                    }
        
                }
            });
        }
    
}
