
DELIMITER //

CREATE procedure getDepSummary(
   IN location VARCHAR(20)
)
Begin
   select pname , max(psalary) , min(psalary) , avg(psalary) , count(*) from professor, department where professor.pdno = department.dno and department.dlocation=location group by pname , pno ;
End //

DELIMITER ;
