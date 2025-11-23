import { Routes } from '@angular/router';
import { DiscoverComponent } from '../discover/discover.component';
import { AppComponent } from './app.component';
import { CreateBlogComponent } from './create-blog/create-blog.component';

export const routes: Routes = [
    { path: "", component: AppComponent },
    { path: 'discover', component: DiscoverComponent },
    { path: 'create-blog', component: CreateBlogComponent }
];
