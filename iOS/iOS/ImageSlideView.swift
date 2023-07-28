//
//  ImageSlideView.swift
//  iOS
//
//  Created by 김지현 on 2023/07/28.
//

import SwiftUI

struct ImageSlideView: View {
	private let timer = Timer.publish(every: 1, on: .main, in: .common).autoconnect()
	@State private var selection: Int = 0
	private let images: [String] = ["slide1", "slide2", "slide3"]
	
	var body: some View {
		TabView(selection: $selection) {
			ForEach(images, id: \.self) {
				Image($0)
					.resizable()
					.scaledToFill()
			}
		}
		.tabViewStyle(.page)
		.onReceive(timer, perform: { _ in
			withAnimation {
				selection = selection < 3 ? selection + 1 : 0
			}
		})
	}
}

struct ImageSlideView_Previews: PreviewProvider {
	static var previews: some View {
		ImageSlideView()
	}
}
