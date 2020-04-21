# Write your MySQL query statement below
select
    Request_at as Day,
    (
        round(
            sum(if(Status!='completed',1,0))/count(Status)
            ,2)
    )as 'Cancellation Rate'
from
    (select
        *
     from
        Users inner join Trips
     on
        Users_Id=Client_Id
     and
        Banned='No'
     where
        Request_at between '2013-10-01' and '2013-10-03'
    ) as t
group by
    Request_at
;