# How to write a DynamicObjectAdapter for an external class ?

* write an Adapter with Delegator for the external class
* extract an interface for the Adapter
* annotate this interface with @DynamicObjectAdapterBuilder

after the compile you will have an DAO for the Adapter - implemenation

Now we could start to inject the DAO and adapt methods for ex. to mock some parts out.


