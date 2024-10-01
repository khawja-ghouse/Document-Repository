## Spring Security

Spring Security is like hiring a full-time security guard who sits in front of  our web application and examines every request to our application and asks these to basic questions

Who is this request from? and what do they want?

So, spring security is an application framework, that helps you do application-level security.

![[Ch-10/Imaages/image-1.png]]

### What Spring Security can do?
![[Ch-10/Imaages/image-2.png]]

5 core concepts in spring security

1.     Authentication
2.     Authorization
3.     Principal
4.     Granted Authority
5.     Role

### Authentication
1. **Knowledge Based Authentication**
   ![[Ch-10/Imaages/image-3.png]]
   Consider the example of Facebook login, each user will have an ID, and in order to use the application he needs to provide the proper password and login, and then he will be able to access the services. This type of authentication is Knowledge-based authentication.
   
   ![[Ch-10/Imaages/image-4.png]]
   
   Advantage its easy to implement, but it also has a disadvantage if anyone else got to know the password then this becomes useless.
   
2.  **Possession-based authentication**
	For example, if an app sends you a text message and asks you to enter the sent message.
		a.	Phone / Text messages
		b.	Key cards and badges
		c.	Access token device
 
	Some do a combination of both knowledge-based and Possession based auth called as Multi factor 	Authentication.
    NOTE: That’s authentication just answering the question of who are you. and prove who you are.

### Authorization
**Authorization**: After authentication, authorization determines what actions or resources the authenticated user (or principal) is allowed to access.

![[Ch-10/Imaages/image-5.png]]

![[Ch-10/Imaages/image-6.png]]

![[Ch-10/Imaages/image-7.png]]

### Principal
In Spring Security, when a user logs in:

- The user’s identity (username, roles, etc.) is stored as the **Principal**.
- This **Principal** can then be used in the system to check whether the user has the necessary permissions to perform certain actions.

For example, after logging in, if you need to know who the current user is, you can retrieve the **Principal** object to get details about the authenticated user.

### Granted Authority 

How does authorization happen?

The user is trying to do something in an application the application will allow or authorize then to do it only if the user is been granted the authority to do so.

![[Ch-10/Imaages/image-8.png]]

**Role**

Is a group of authorities assigned together, this makes things simple and consistance.

![[Ch-10/Imaages/image-9.png]]