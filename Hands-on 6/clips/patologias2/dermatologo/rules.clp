
;;Define a rule for finding those customers who have not bought nothing at all... so far

(defrule cancer-piel
     (paciente (nombre ?n)(sintoma1 manchas-marron) (sintoma2 picor-piel) (sintoma3 lunares-sangrado))
   =>
   (printout t "El paciente " ?n " tiene cancer de piel y fue diagnosticado por el dermatologo" crlf))


(defrule psoriasis
     (paciente (nombre ?n)(sintoma1 manchas-rojas) (sintoma2 piel-seca) (sintoma3 articulaciones-inflamadas))
   =>
   (printout t "El paciente " ?n " una psoriasis  y fue diagnosticado por el dermatologo" crlf))
