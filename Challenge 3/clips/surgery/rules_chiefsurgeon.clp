
;;Define a rule for finding those customers who have not bought nothing at all... so far

(defrule r1(patient ready)
   =>
   (printout t "El paciente está anesteciado" crlf)(retract 1)(assert(patient anesthetize) )

