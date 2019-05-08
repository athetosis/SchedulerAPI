## SchedulerAPI
An API dealing with the non-user-friendliness of the Bukkit API's Scheduler component.
[This project has not been updated since Spigot 1.8.9, there is not guarantee that it will work with further versions!]

<b>To Use:</b> Copy/Paste the contents of the SchedulerAPI.java into a new class called SchedulerAPI in your bukkit plugin.
(Then change the package name, of course)

<b>First,</b> you need to add the following code to the onEnable and onDisable methods in your main class:
```java
@Override
public void onEnable() {
    Scheduler.onEnable(this);
}

@Override
public void onDisable() {
    Scheduler.onDisable();
}
```
Note: The SchedulerAPI.onEnable() method returns true if successful, false if not!

Now, you're ready to use the API! There are two ways to schedule delayed tasks:
```java
Scheduler.scheduleDelayedTask(() -> {

}, double delayInTicks);
```

Or, if you need more options, you can do it like this:
```java
Scheduler.scheduleDelayedTask(() -> {

}, double delay, String options);
```

Similarly enough, you can schedule a repeating task simply:
```java
Scheduler.scheduleRepeatingTask(() -> {

}, double intervalInTicks);
```

Or the more complicated way:
```java
Scheduler.scheduleRepeatingTask(() -> {

}, double interval, String options);
```

As you can see, in some of these methods, there is a String argument called "options."
You can input various options to change the behavior of the method.
Some of the options include the following:<br><br>
```"sync:false"``` runs your code async.<br>
```"measurement:seconds"``` changes your delay to be in seconds instead of ticks.<br>
```"delay:10"``` (Repeating tasks only). Delays your repeating task by that many of ticks or seconds, depending on which time measurement you're using.

You can use multiple options in the same string. Seperate them with a space only. For example:
```java
Scheduler.scheduleRepeatingTask(() -> {


}, 10, "sync:false measurement:seconds delay:5");

```


Without Lambdas (All versions of Java)
You can adapt the following snippets to meet your own needs:
```java
SchedulerAPI.scheduleDelayedTask(new Runnable() {
    @Override
    public void run() {
        // run code here
    }
}, arguments);

SchedulerAPI.scheduleRepeatingTask(new Runnable() {
    @Override
    public void run() {
        // run code here
    }
}, arguments);
```
