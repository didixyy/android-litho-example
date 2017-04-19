package io.podcst.android.specs;

import android.graphics.Color;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.litho.Column;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.fresco.FrescoImage;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;

import io.podcst.android.R;
import io.podcst.android.data.Podcast;

/**
 * Created by eve on 19/04/17.
 */

@LayoutSpec
public class PodcastDetailsSpec {

    @OnCreateLayout
    static ComponentLayout onCreateLayout(ComponentContext c, @Prop Podcast podcast) {

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(podcast.cover)
                .build();

        ComponentLayout.ContainerBuilder text = Column.create(c)
                .paddingDip(YogaEdge.ALL, 16)
                .child(
                        Text.create(c)
                                .text(podcast.title)
                                .textSizeSp(20)
                                .textStyle(android.graphics.Typeface.BOLD)
                ).child(
                        Text.create(c)
                                .text(podcast.author)
                                .textSizeSp(12)
                );

        return Column.create(c)
                .backgroundColor(Color.WHITE)
                .child(
                        FrescoImage.create(c)
                                .placeholderImageRes(R.drawable.ic_placeholder_cover)
                                .placeholderImageScaleType(ScalingUtils.ScaleType.CENTER_CROP)
                                .controller(controller)
                ).child(
                        text
                ).build();
    }
}
