One-to-one Mapping
Unidirectional Mapping
1.	Using a Foreign key association.
	 In this kind of association, a foreign key column is created in the **owner entity**. For example, if we have made **Instructor** owner, then an extra column "**_instructor_detail_id_**" will be created in the **instructor** table. This column will store the foreign key for the **instructor_detail** table.
	To make such an association, refer to the **Instructor_Detail** entity in an **Instructor** entity class
	![[Ch-9/Images/image-1.png]]
	
	Also, **we need to place the _@JoinColumn_ annotation** to configure the name of the column in the _instructor_ table that maps to the primary key in the _instructor_details_ table. If we don't provide a name, hibernate will follow some rules to select a default one.

	Finally, note in the next entity that we won't use the _@JoinColumn_ annotation there. This is because we only need it on the owning side of the foreign key relationship. **Simply put, whoever owns the foreign key column gets the _@JoinColumn_ annotation.**
	