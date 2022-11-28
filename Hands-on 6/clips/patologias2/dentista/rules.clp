
;;Define a rule for finding those customers who have not bought nothing at all... so far

(defrule cancer-oral
     (paciente (nombre ?n)(sintoma1 ulcera-bocal) (sintoma2 manchas-boca) (sintoma3 dificultad-comer))
   =>
   (printout t "El paciente " ?n " tiene cancer oral y fue diagnosticado por el dentista" crlf))


(defrule caries
     (paciente (nombre ?n)(sintoma1 mal-aliento) (sintoma2 sangrado-encias) (sintoma3 dolor-encias))
   =>
   (printout t "El paciente " ?n " tiene caries y fue diagnosticado por el dentista" crlf))

(defrule gingivitis
     (paciente(nombre ?n)(sintoma1 encias-inflamadas) (sintoma2 mal-aliento) (sintoma3 encias-oscuras))
   =>
   (printout t "El paciente " ?n " tiene una gingivits y fue diagnosticado por el dentista" crlf))
