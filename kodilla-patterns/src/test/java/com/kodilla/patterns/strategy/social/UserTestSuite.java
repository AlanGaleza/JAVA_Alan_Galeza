package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.socialMediaPublisher.SnapchatPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User facebook = new Millenials("HeniekFacebook");
        User snapchat = new YGeneration("FranekSnapchat");
        User twitter = new ZGeneration("MietekTwitter");

        //When
        String facebookShare = facebook.sharePost();
        System.out.println("HeniekFacebook: " + facebookShare);
        String snapchatShare = snapchat.sharePost();
        System.out.println("FranekSnapchat: " + snapchatShare);
        String twitterShare = twitter.sharePost();
        System.out.println("MietekTwitter: " + twitterShare);

        //Then
        Assert.assertEquals("Facebook", facebookShare);
        Assert.assertEquals("Snapchat", snapchatShare);
        Assert.assertEquals("Twitter", twitterShare);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User facebook = new Millenials("Steven Links");

        //When
        String facebookShare = facebook.sharePost();
        System.out.println("HeniekFacebook: " + facebookShare);
        facebook.setSocialPublisher(new SnapchatPublisher());
        facebookShare = facebook.sharePost();
        System.out.println("HeniekFacebook: " + facebookShare);

        //Then
        Assert.assertEquals("Snapchat", facebookShare);
    }
}
