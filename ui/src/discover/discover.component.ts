import { Component, OnInit } from '@angular/core';
import { BlogService } from '../services/blog/blog.service';
import { CommonModule } from "@angular/common";
import { Blog } from '../model/blog';

@Component({
  selector: 'app-discover',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './discover.component.html',
  styleUrl: './discover.component.css'
})
export class DiscoverComponent implements OnInit {
  blogs: Blog[] = [];

  constructor(private blogService: BlogService) {}

  ngOnInit(): void {
    this.blogService.getAllBlogs().subscribe((data) => {
      console.log("In discover component - getAllBlogs");
      console.log(data);
      this.blogs = data.data;
    });
  }

}
