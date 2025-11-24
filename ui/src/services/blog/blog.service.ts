import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Blog } from '../../model/blog';
import { Response } from '../../model/response';
import { SuccessResponse } from '../../model/successfulresponse';

@Injectable({
  providedIn: 'root'
})
export class BlogService {
  private apiUrl = 'http://localhost:8080'

  constructor(private httpClient: HttpClient) { }

  getAllBlogs(): Observable<any> {
    var response = this.httpClient.get<Response>(`${this.apiUrl}/blog/getAll`);
    console.log("In blog service - getAllBlogs");
    console.log(response);
    if(response instanceof SuccessResponse){
      console.log("Response is SuccessResponse");
      console.log(response.data);
    }
    return response;
  }

  createBlog(blogData: any): Observable<any> {
    return this.httpClient.post<any>(`${this.apiUrl}/blog/create-blog`, blogData)
  }

  updateBlog(blogId: any, blogData: any) {
    return this.httpClient.put<any>(`${this.apiUrl}/blog/update-blog`, blogData, {
      params: {
        "id": blogId
      }
    });
  }
}
