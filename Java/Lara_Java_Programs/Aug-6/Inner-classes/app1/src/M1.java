class Job
{
	String title;
	double salary;
	Job(String title,double salary)
	{
		this.title = title;
		this.salary = salary;
	}
}
class Employee
{
	String name;
	Job[] jobs;//{j1,j2,j3}//jobs.length = 3
	private int index;//default 0
	Employee(String name ,Job[] jobs)
	{
		this.name = name;
		this.jobs = jobs;
	}
	boolean hasNext()
	{
		return index < jobs.length;//when 3 < 3 return false
	}
	Job nextJob()
	{
		return jobs[index++];//0->1->2->3
	}
}
class M1
{
	public static void main(String[] args) 
	{
		Job j1 = new Job("software",50000);
		Job j2 = new Job("hardware",25000);
		Job j3 = new Job("hr",15000);
		Job[] jobs = {j1,j2,j3};
		Employee e1 = new Employee("vijay",jobs);
		Job job;
		while (e1.hasNext())
		{
			job = e1.nextJob();//e1.jobs[0],e1.jobs[1],e1.jobs[2]
			System.out.println(job.title + ":" + job.salary);
			
		}
		System.out.println("-----------------");
		while (e1.hasNext())
		{
			job = e1.nextJob();
			System.out.println(job.title + ":" + job.salary);
		}
		System.out.println("-----------------");
	}
}
