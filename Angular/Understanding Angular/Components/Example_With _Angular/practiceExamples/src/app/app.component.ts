import { Component,OnInit } from '@angular/core';
import { AdService } from 'src/services/ad.service';
import { AdItem } from './ad-item';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit  {
  count = 0;
  ads: AdItem[] = [];
  color = '';

  constructor(private adService: AdService ){

  }
  ngOnInit() {
    this.ads = this.adService.getAds();
  }

}
