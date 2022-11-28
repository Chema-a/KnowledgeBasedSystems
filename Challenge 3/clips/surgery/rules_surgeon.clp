(defrule r1(patient anesthetized) => 
(printout t"El cirujano empezara la cirugia del paciente" crlf)(assert(patient surgery)))