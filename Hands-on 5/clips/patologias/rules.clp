
;;Define a rule for finding those customers who have not bought nothing at all... so far

(defrule gripe
     (paciente (nombre ?n)(sintoma1 dolor-garganta) (sintoma2 fiebre) (sintoma3 tos))
   =>
   (printout t "El paciente " ?n " tiene gripe" crlf))


(defrule infeccion-estomacal
     (paciente (nombre ?n)(sintoma1 cansancio) (sintoma2 fiebre) (sintoma3 dolor-estomago))
   =>
   (printout t "El paciente " ?n " una infección estomacal" crlf))

(defrule alergia
     (paciente(nombre ?n)(sintoma1 comezon) (sintoma2 enrojecimiento) (sintoma3 fiebre))
   =>
   (printout t "El paciente " ?n " tiene una alergia" crlf))
