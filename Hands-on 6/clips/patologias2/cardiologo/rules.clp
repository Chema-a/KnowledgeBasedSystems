
;;Define a rule for finding those customers who have not bought nothing at all... so far

(defrule arritmia-cardiaca
     (paciente (nombre ?n)(sintoma1 mareo) (sintoma2 desmayo) (sintoma3 dolor-pecho))
   =>
   (printout t "El paciente " ?n " tiene arritmia cardiaca y fue diagnosticado por el cardiologo" crlf))


(defrule defectos-cardiacos-congenitos
     (paciente (nombre ?n)(sintoma1 piel-gris) (sintoma2 hinchazon-piernas) (sintoma3 dificultad-respirar))
   =>
   (printout t "El paciente " ?n " tiene defectos cardiacos congenitos y fue diagnosticado por el cardiologo" crlf))

(defrule miocardiopatia
     (paciente(nombre ?n)(sintoma1 dolor-pecho) (sintoma2 fatiga) (sintoma3 desmayos))
   =>
   (printout t "El paciente " ?n " tiene una miocardiopatia y fue diagnosticado por el cardiologo" crlf))
