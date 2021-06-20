package com.AssignmentHelloHuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Human {
@RequestMapping("/dojo")
public String name(@RequestParam(value="name") String searchQuery)
{
return "<h1>Hello "+searchQuery+"</h1>"+"<p>Welcome to SpringBoot</p>"+"<a href=http://localhost:8080>Go Back</a>";

}
@RequestMapping("/")
public String human()
{
	return "<h1>Hello Human!</h1>"+"<p>Welcome to SpringBoot</p>";
}
}
