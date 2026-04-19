--a design pattern where an object maintains a list of the observers(dependents)
-- whenever there is a change in state for the publisher it automatically notifies all the observers
--example weather app  , instagram posts , youtube subscriptions
-- push approach : observable pushes the data to all the observers
-- pull approach : observer holds the object for observable , when it get to know something is updated it pulls
the data using the observable object