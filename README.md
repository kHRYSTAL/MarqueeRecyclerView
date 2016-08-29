### MarqueeRecyclerView

#### screenshot

![](https://github.com/kHRYSTAL/MarqueeRecyclerView/blob/master/screenshot.gif)

#### usage
 
##### step 1: set your RecyclerView.Adapter<VH> infinite loop

```
    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        int imageRes = mDataList.get(position % mSize);
        if (imageRes != 0x0) {
            holder.bind(imageRes);
        }
    }

   
    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

```


##### step 2: set marquee direction and speed(shift and sleepTime)

```

//      your shift and sleep time
        marquee1.setScrollSpeed(-1, 100);
        marquee2.setScrollSpeed(1, 100);
//      your direction        
        marquee1.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, true));
        marquee2.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));

```
