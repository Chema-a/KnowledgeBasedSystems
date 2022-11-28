;;Define a rule for finding those customers who have not bought nothing at all... so far

(defrule r2(patient anesthesize)
   =>
   (printout t "El paciente está anestesiado" crlf)(assert(patient anesthetized)))

