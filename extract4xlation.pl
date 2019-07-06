#!/usr/bin/perl -w

use strict;

# use XML::Parser;

use XML::DOM;

# use XML::DOM::Parser;

use XML::LibXML;


sub main
{
    my $binding = "pushbullet";
    my $thingId = "bot";

    my $thingLabel = "x";
    my $thingDesc = "x";

    # bundles/org.openhab.binding.pushbullet/ESH-INF/config/config-description.xml
    # bundles/org.openhab.binding.pushbullet/ESH-INF/binding/binding.xml
    # bundles/org.openhab.binding.pushbullet/ESH-INF/thing/channels.xml
    # bundles/org.openhab.binding.pushbullet/ESH-INF/thing/box.xml

    my $parser = new XML::DOM::Parser;

    # my $p1 = XML::Parser->new(Style => 'Debug');

    # my $docBinding = $parser->parsefile("bundles/org.openhab.binding." . ${binding} . "/ESH-INF/binding/binding.xml");

    # print $docBinding->toString . "\n";

    # my $bindingName = $docBinding->getElementsByTagName("name");
    # print $bindingName . "\n";

    # my $nodes = $bindingName;
    # my $n = $nodes->getLength;

    # print "FOO: " . $bindingName->item(0)->toString . "\n";
    # for (my $i = 0; $i < $n; $i++)
    # {
    #         my $node = $nodes->item($i);
    #         print "GAGA: " . $node->toString . "\n";

    #         # $thingId = $node->getAttributeNode("id")->getValue;
    # }
    
    my $thing_types_filename = "src/main/resources/ESH-INF/thing/thing-types.xml";

    my $docBox = $parser->parsefile($thing_types_filename);

    # print $docBox->toString . "\n";

    my $thingTypes = $docBox->getElementsByTagName ("thing-type");
    my $n = $thingTypes->getLength;

    for (my $i = 0; $i < $n; $i++)
    {
        my $node = $thingTypes->item($i);

        $thingId = $node->getAttributeNode("id")->getValue;
        if ($thingId eq "bot")
        {
            # print $node->toString . "\n";

            {
                my $subNode = $node->getElementsByTagName("label")->item(0);

                my @foo = $subNode->getChildNodes();
                $thingLabel = $foo[0]->toString;
                # print $thingLabel . "\n";
            }

            {
                my $subNode = $node->getElementsByTagName("description")->item(0);

                my @foo = $subNode->getChildNodes();
                $thingDesc = $foo[0]->toString;
                # print $thingDesc . "\n";
            }

        }
    }

    my $extracted_filename = "src/main/resources/ESH-INF/i18n/${binding}_en.extracted.properties";
    open (EXTRACTED, "> $extracted_filename") || die ("Can't open $extracted_filename to write: $!\n");

    print EXTRACTED "# thing types\n";

    print EXTRACTED "thing-type." . ${binding} . "." .${thingId} . ".label = " . $thingLabel . "\n";
    print EXTRACTED "thing-type." . ${binding} . "." .${thingId} . ".description = " . $thingDesc . "\n";
    print EXTRACTED "\n";

    # thing-type.${thingId}.audiogroup.label = ${ThingId} Audiogruppe
    # thing-type.${thingId}.audiogroup.description = Audiogruppe aus mehreren Chromecast Audio oder Media Playern.

    # thing-type.${thingId}.audio.label = Chromecast Audio
    # thing-type.${thingId}.audio.description = Chromecast Audio Player

    # thing-type.${thingId}.chromecast.label = Chromecast
    # thing-type.${thingId}.chromecast.description = Chromecast Media Player

    # thing-type.config.${thingId}.device.ipAddress.label = IP-Adresse
    # thing-type.config.${thingId}.device.ipAddress.description = Lokale IP-Adresse oder Hostname des Chromecast Gerätes.
    # thing-type.config.${thingId}.device.port.label = Port
    # thing-type.config.${thingId}.device.port.description = Port des Chromecast Gerätes.

    print EXTRACTED "# thing type configuration\n";

    my $parameterTypes = $docBox->getElementsByTagName("parameter");

    for (my $i = 0; $i < $parameterTypes->getLength; $i++)
    {
	my $node = $parameterTypes->item($i);
	# print $node->toString . "\n";

	my $parameterId = "x";
	my $parameterLabel = "x";
	my $parameterDesc = "x";

	$parameterId = $node->getAttributeNode("name")->getValue;
	# print $parameterId . "\n";

	{
	    my $subNode = $node->getElementsByTagName("label")->item(0);

	    my @foo = $subNode->getChildNodes();
	    $parameterLabel = $foo[0]->toString;
	}

	{
	    my $subNode = $node->getElementsByTagName("description")->item(0);

	    my @foo = $subNode->getChildNodes();
	    $parameterDesc = $foo[0]->toString;
	}

	print EXTRACTED "thing-type.config." . ${binding} . "." .${thingId} . "." .${parameterId} . ".label = " . $parameterLabel ."\n";
	print EXTRACTED "thing-type.config." . ${binding} . "." .${thingId} . "." .${parameterId} . ".description = " . $parameterDesc . "\n";
	print EXTRACTED "\n";
    }

    # print EXTRACTED "thing-type.config.pushbullet.bot.name.label = Name of Bot\n";
    # print EXTRACTED "thing-type.config.pushbullet.bot.name.description = Long description of Name of Bot\n";
    # print EXTRACTED "\n";
    # print EXTRACTED "thing-type.config.pushbullet.bot.token.label = Token of Bot\n";
    # print EXTRACTED "thing-type.config.pushbullet.bot.token.description = Long description of Token of Bot\n";
    
    print EXTRACTED "# channel types\n";

    my $channelTypes = $docBox->getElementsByTagName("channel-type");

    for (my $i = 0; $i < $channelTypes->getLength; $i++)
    {
	my $node = $channelTypes->item($i);
	# print $node->toString . "\n";

	my $channelId = "x";
	my $channelLabel = "x";
	my $channelDesc = "x";

	$channelId = $node->getAttributeNode("id")->getValue;
	# print $channelId . "\n";

	{
	    my $subNode = $node->getElementsByTagName("label")->item(0);

	    my @foo = $subNode->getChildNodes();
	    $channelLabel = $foo[0]->toString;
	}

	{
	    my $subNode = $node->getElementsByTagName("description")->item(0);

	    my @foo = $subNode->getChildNodes();
	    $channelDesc = $foo[0]->toString;
	}

	print EXTRACTED "channel-type." . ${binding} . "." .${channelId} . ".label = " . $channelLabel ."\n";
	print EXTRACTED "channel-type." . ${binding} . "." .${channelId} . ".description = " . $channelDesc . "\n";
	print EXTRACTED "\n";
    }

    # print EXTRACTED "channel-type.pushbullet.recipient-channel.label = Recipient Channel\n";
    # print EXTRACTED "channel-type.pushbullet.recipient-channel.description = Long description of Recipient Channel\n";
    # print EXTRACTED "\n";
    # print EXTRACTED "channel-type.pushbullet.title-channel.label = Title Channel\n";
    # print EXTRACTED "channel-type.pushbullet.title-channel.description = Long description of Title Channel\n";
    # print EXTRACTED "\n";
    # print EXTRACTED "channel-type.pushbullet.message-channel.label = Message Channel\n";
    # print EXTRACTED "channel-type.pushbullet.message-channel.description = Long description of Message Channel\n";

    # channel-type.${thingId}.playuri.label = URI abspielen
    # channel-type.${thingId}.playuri.description = Ermöglicht das Abspielen einer URI.
    # channel-type.${thingId}.metadataType.label = Medientyp
    # channel-type.${thingId}.metadataType.description = Zeigt den Medientyp des aktuellen Stücks oder Films (z. B. MOVIE, AUDIO_TRACK) an.
    # channel-type.${thingId}.albumName.label = Album
    # channel-type.${thingId}.albumName.description = Zeigt das Album des aktuellen Stücks an.
    # channel-type.${thingId}.metadataType.label = Medientyp
    # channel-type.${thingId}.metadataType.description = Zeigt den Medientyp des aktuellen Stücks oder Films (z. B. movie, song) an.
    # channel-type.${thingId}.image.label = Thumbnail
    # channel-type.${thingId}.image.description = Zeigt das Thumbnail des aktuellen Stücks oder Films an.
    # channel-type.${thingId}.currentTime.label = Laufzeit
    # channel-type.${thingId}.currentTime.description = Zeigt die Laufzeit des aktuellen Stücks oder Films an.
    # channel-type.${thingId}.duration.label = Dauer
    # channel-type.${thingId}.duration.description = Zeigt die Dauer des aktuellen Stücks oder Films an.

    close (EXTRACTED);
}


main();
