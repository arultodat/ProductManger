package com.Article.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.Article.model.Article;
import com.Article.repository.ArticleRepository;
@RestController
@Path("/articles")
public class Articleservice {
	
	@Autowired
	private ArticleRepository articleRepository;

	@GET
	@Path("/") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response getArticleDetails()
	{
		List<Article> articles = new ArrayList<>();
		Iterable<Article> articlesIterable = articleRepository.findAll();
		articlesIterable.forEach(articles::add);
		System.out.println(articles);
		return Response.ok(articles).build(); 
		/* return articles; */
		 
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getArticaleById(@PathParam("id") Long id)
	{
		Optional<Article> article = articleRepository.findById(id);
		if(article.isPresent())
			return Response.ok(article).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("Not Found").build();
	}
	
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addArticle(Article article)	
	{
		article = articleRepository.save(article);
		return Response.status(Response.Status.ACCEPTED).entity(article).build();
	}
	
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateArticle(Article article)	
	{
		articleRepository.save(article);
		return Response.ok(article).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response deleteArticle(@PathParam("id") Long id)	
	{
		articleRepository.deleteById(id);
		return Response.noContent().build();
	}
}
