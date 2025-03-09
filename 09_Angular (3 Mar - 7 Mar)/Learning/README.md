#Routing

/
/app
/about

top level routes, root leve

/app/module1
/app/feature2  

child routes

top level routing -> RouterModule.forRoot()
child level routing -> RouterModule.forChildren()


### Services

A Service is angular future which is basically a class
with functions that could be used reusably across multiple
components

in other words a service provides reusable features to multiple components

A service need to be injected in to the component in order to use it

we follow constructor inject 

By default services are singleton (everywhere if you inject
you will get same object)

but if you want a different object that could also be done


#### HttpClient Module

##### HttpClient service 

using this service we can call api using get,post,put,delete....methods

and all of this methods return object of type Observable

### Observable

In reactive programming(asynchronous coding), Observable is
an object which listens to responses and process it as an when
the original function sends it 

this is used for processing logic that requires time and where
data cannot be returned immediatly


### pipes

Pipes are generally used in the template of angular component

it is applied on varibles used in the interpolation

for example 

{{ firstname | uppercase }}

if firstname is Raj  after pipe application --> RAJ

{{ price | currency : 'INR '}}

if price is 2000 after pipe application -> ₹ 2000

Pipes constituents
--------------------

* Pipe has a name
* Pipe has a target
* Pipe can have(optional) parameter(s)

Pipe Targets
-------------

If pipe target is a scalar variable(string,number) the
result would a transformed of formatted result

if pipe target is an array usually the result is
a filter of the array values(based on conditions array will be filtered)

There are few inbuilt pipes for scalar variables

there is no inbuilt pipes for targetting arrays(you have
to create custom pipes)

Pipes can be created in a custom way also
both to be applied on scalar and arrays