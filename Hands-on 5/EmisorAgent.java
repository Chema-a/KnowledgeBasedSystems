/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examples.clips.agents;
import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import net.sf.clipsrules.jni.*;

/**
 *
 * @author chiva
 */
public class EmisorAgent extends Agent {
    protected void setup() {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                System.out.println("Han llegado dos pacientes, uno llamado ISRAEL a revisión con los sintomas de ULCERAS BOCALES, MANCHAS EN BOCA Y DIFICULTAD PARA COMER y José con ARTICULACIONES INFLAMADAS, MANCHAS ROJAS EN PIEL Y ARDOR , enseguida será diagnosticado");
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.setContent("(paciente (nombre Juan)(sintoma1 cansancio) (sintoma2 fiebre) (sintoma3 dolor-estomago))");
                msg.addReceiver(new AID("doctor",AID.ISLOCALNAME));
                send(msg);
            }
        });
    }
    
}
